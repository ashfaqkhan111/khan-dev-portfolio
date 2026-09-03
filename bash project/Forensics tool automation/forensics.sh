#!/bin/bash

read -p "Enter PDF filename: " file

if [ ! -f "$file" ]; then
echo "File not Found!"
exit 1
fi

sha256sum "$file" > shafolder/sha256.txt

md5sum "$file" > md5folder/md5.txt

ls -la "$file" > listingfolder/listing.txt

stat "$file" > statfolder/stat.txt

head -c 1024 "$file" | strings > headerfolder/header.txt

xxd "$file" | head -20 > headerfolder/header_xxd.txt

exiftool "$file" > metadatafolder/metadata.txt

exiftool -a -u -g1 "$file" > metadatafolder/group_metadata.txt

pdfinfo "$file" > metadatafolder/pdfinfo.txt

qpdf --qdf --object-streams=disable "$file" structurefolder/suspect_readable.pdf

qpdf --check "$file" > encryptionfolder/result.txt

grep -abo '%%EOF' "$file" > revisionfolder/revisionresult.txt

{
for keyword in /OCG /OpenAction /JavaScript /JS /Launch /EmbeddedFile /RichMedia /AA; do
    echo "===== $keyword ====="
    python3 /home/ashfaq-khan/Desktop/DidierStevensSuite/pdf-parser.py \
    "$file"  --search "$keyword" -O
    echo
done
} > keywordsfolders/results.txt

pdfdetach -list "$file" > embadedfolder/attachments_list.txt

pdfdetach -saveall -o embadedfolder "$file"

pdfimages -all "$file" images/

exiftool images/* > metadataimages.txt

pdffonts "$file" > fonts/result.txt

pdftotext -layout "$file" textextrcfolder/layout_text.txt

pdftotext -raw "$file" textextrcfolder/raw_text.txt

diff textextrcfolder/layout_text.txt textextrcfolder/raw_text.txt > textextrcfolder/difference.txt

pdfsig "$file" > signaturefolder/sign.txt

qpdf --show-encryption "$file"> encryptionfolder/showencryp.txt

strings -a "$file" > fullrawdump/raw.txt

xxd "$file" > fullrawdump/rawxxd.txt




echo "done!"
echo "!!! suspect.pdf is orignal file"
echo "1. Run (less suspect_readable.pdf to analyse the structure with orignal file)"
echo "2. Run (head -c revision number suspect.pdf > revision1.pdf) run several times depend how many revision did you get"
echo "3. Run (diff <(pdftotext revision1.pdf -) <(pdftotext suspect.pdf -) to get how what was changed in revisions then the orignal file run several times depend how many revision do you have"
