# PDF Forensics Automation Script — README

## What this does

`forensics.sh` is a simple Bash automation script for doing a first-pass forensic
triage of a PDF file. It asks you for a PDF filename, then runs a batch of
standard forensic/analysis tools against it (hashing, metadata extraction,
structure dumping, keyword/JavaScript scanning, embedded file extraction,
signature checking, revision detection, etc.) and saves every result into
separate output folders.

It's meant as a quick "run once, get everything" starting point — not a
polished tool. You still do the actual analysis by reading the output files
it produces.

---

## 1. Requirements — tools you need installed

All of these are command-line tools. On Debian/Ubuntu you can install most of
them in one shot:

```bash
sudo apt update
sudo apt install -y \
    coreutils \
    xxd \
    exiftool \
    poppler-utils \
    qpdf \
    python3
```

That covers:

| Tool | Used for | Comes from |
|---|---|---|
| `sha256sum`, `md5sum`, `stat`, `ls` | hashing / file listing | `coreutils` (built in on Linux) |
| `xxd` | hex dump | `xxd` package |
| `strings` | extracting readable text/header strings | `binutils` (usually preinstalled) |
| `exiftool` | metadata extraction | `exiftool` (Perl-based, its own package) |
| `pdfinfo`, `pdfdetach`, `pdfimages`, `pdffonts`, `pdftotext`, `pdfsig` | PDF-specific analysis | `poppler-utils` |
| `qpdf` | structure normalization ("qdf" mode), encryption check | `qpdf` |
| `python3` | running the Didier Stevens `pdf-parser.py` script | `python3` |

You will also need **Didier Stevens' PDF tools** (specifically `pdf-parser.py`),
which is not an apt package — download it manually:

```bash
git clone https://github.com/DidierStevens/DidierStevensSuite.git
```

> ⚠️ **Important:** the script currently has this path hardcoded:
> ```
> /home/ashfaq-khan/Desktop/DidierStevensSuite/pdf-parser.py
> ```
> You **must** edit this path in the script to point to wherever you cloned
> `DidierStevensSuite` on your own machine, or the keyword-scan step will fail.

---

## 2. Folder setup (must be done before running)

The script writes into subfolders but **does not create them itself**. Before
running it, create this folder structure in the same directory as
`forensics.sh`:

```bash
mkdir -p shafolder md5folder listingfolder statfolder headerfolder \
         metadatafolder structurefolder encryptionfolder revisionfolder \
         keywordsfolders embadedfolder images fonts textextrcfolder \
         signaturefolder fullrawdump
```

If a folder is missing, whichever command writes to it will fail silently
(redirection to a non-existent directory errors out) and that step's output
will simply be missing.

---

## 3. How to run it

1. Make the script executable (one-time):
   ```bash
   chmod +x forensics.sh
   ```
2. Put the PDF you want to analyze in the same directory (or know its path).
3. Run it:
   ```bash
   ./forensics.sh
   ```
4. When prompted:
   ```
   Enter PDF filename:
   ```
   type the filename (or path), e.g. `suspect.pdf`, and press Enter.
5. Wait for it to finish — it will print `done!` when complete.

---

## 4. What you get out of it

| Folder | Contents |
|---|---|
| `shafolder/` | SHA-256 hash of the file |
| `md5folder/` | MD5 hash of the file |
| `listingfolder/` | `ls -la` output (size, permissions, timestamps) |
| `statfolder/` | `stat` output (detailed filesystem metadata) |
| `headerfolder/` | First 1KB of the file as readable strings + hex dump |
| `metadatafolder/` | ExifTool metadata (normal + grouped), `pdfinfo` output |
| `structurefolder/` | A "readable" re-written version of the PDF (`qpdf --qdf`), useful for viewing the raw PDF structure in a text editor |
| `encryptionfolder/` | `qpdf --check` results and encryption details |
| `revisionfolder/` | Byte offsets of every `%%EOF` marker — tells you how many incremental revisions the PDF has |
| `keywordsfolders/` | Results of scanning for suspicious PDF keywords (`/OpenAction`, `/JavaScript`, `/JS`, `/Launch`, `/EmbeddedFile`, `/RichMedia`, `/AA`, `/OCG`) using `pdf-parser.py` |
| `embadedfolder/` | List of embedded/attached files, plus the extracted files themselves |
| `images/` | All images extracted from the PDF |
| `metadataimages.txt` | ExifTool metadata run on every extracted image |
| `fonts/` | List of fonts used in the PDF |
| `textextrcfolder/` | Extracted text (`-layout` and `-raw` modes) and a diff between the two |
| `signaturefolder/` | Digital signature info (`pdfsig`) |
| `fullrawdump/` | Full `strings` output and full `xxd` hex dump of the entire file |

---

## 5. Manual follow-up steps (printed by the script at the end)

The script's last lines are analysis suggestions, not automated steps — you
run these yourself afterward:

1. **Inspect structure:**
   ```bash
   less structurefolder/suspect_readable.pdf
   ```
2. **Split out a revision** (based on the `%%EOF` byte offsets found in
   `revisionfolder/revisionresult.txt`):
   ```bash
   head -c <revision_byte_offset> suspect.pdf > revision1.pdf
   ```
   Repeat for each revision offset found.
3. **Diff a revision against the final file** to see what changed:
   ```bash
   diff <(pdftotext revision1.pdf -) <(pdftotext suspect.pdf -)
   ```
   Repeat for each revision.

---

## 6. Known limitations / things to fix if you plan to reuse this

- **No folder auto-creation** — see Section 2. Consider adding
  `mkdir -p shafolder md5folder ...` near the top of the script.
- **Hardcoded absolute path** to `pdf-parser.py` — see Section 1's warning.
- **No error checking** on individual commands — if a tool isn't installed or
  a step fails, the script keeps going silently.
- **Filenames are fixed** (e.g. always `sha256.txt`, `md5.txt`) — running it
  twice on different PDFs will overwrite previous results. Consider naming
  output files after the input PDF, or timestamping the run, if you'll be
  analyzing multiple files.
- Assumes a Linux environment with all tools on `PATH`.
