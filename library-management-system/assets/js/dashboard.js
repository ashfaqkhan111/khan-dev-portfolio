new Chart(document.getElementById("borrowChart"),{
    type:"bar",
    data:{
        labels:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],

        datasets:[{
            label:"Borrowings",
            data:[120,200,150,80,70,110,130,250,23,145,210,195],

            backgroundColor:"#6C63FF",
            borderRadius:10
        }]
    },

    options:{
        responsive:true,
        plugins:{
            legend:{
                display:false
            }
        }
    }
});

new Chart(document.getElementById("categoryChart"),{
type:"pie", 
data:{
    labels:["students","Lecturer","Visitors","Staff"],
    datasets:[{
        data:[15,28,47,33],
        backgroundColor:[
            "#6c63ff",
            "#ff7e79",
            "#fdb34b",
            "#47b6d6"
        ]
    }]
},
options:{
    respondive:true
}
});