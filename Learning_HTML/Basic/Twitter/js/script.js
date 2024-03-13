//1111

var picForReview = document.getElementById("picForReview");


document.getElementById("inputFile").addEventListener("change", function(){
     if (this.files[0]) {
         var pic = new FileReader();
         
         pic.readAsDataURL(this.files[0]);
         pic.addEventListener("load", function(event){
                //debugger;
                 
                 picForReview.setAttribute("src", event.target.result);
                 //console.log(this.src);
                 picForReview.style.display="block";
             });
         
     }    
 });


 document.getElementById("postButton").addEventListener("click", function(){
    if (this.file[0]) {

    }
    else {
        
    }
 })