//1111

var modalBackground = document.getElementById("modalBackgroundColorDark"); 
var X_button = document.getElementById("X_button");
var modalInDisplay = document.getElementById("ImgDisplayModal");


document.getElementById("inputFile").addEventListener("change", function(){
     if (this.files[0]) {
         var pic = new FileReader();
         
         pic.readAsDataURL(this.files[0]);
         pic.addEventListener("load", function(event){
             //console.log(event.target);
             document.getElementById("photo").innerHTML = "<img class='imagePhoto' src='' id='" +n+ "' accept='image/png, image/jpeg'>" + document.getElementById("photo").innerHTML;
             document.getElementById(n).setAttribute("src", event.target.result);
             const uploadedPhoto = document.getElementById(n);
             document.getElementById(n).addEventListener("click", (event) => {
                 console.log('piggy');
                 const imgSrc = event.target.getAttribute("src");
                 var modalInDisplay = document.getElementById("ImgDisplayModal");
                 document.getElementById("ImageInDisplay").setAttribute("src", imgSrc);
                 //console.log(this.src);
                 modalInDisplay.style.display = "block";
                 modalBackground.style.display = "block";
                 X_button.style.display = "block";
             
             });
             n += 1;
         });
         
     }    
 });