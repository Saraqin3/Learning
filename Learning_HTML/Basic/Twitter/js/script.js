//1111

var picForReview = document.getElementById("picForReview");
var dynamicImageSrc = null;

document.getElementById("inputFile").addEventListener("change", function(){
     if (this.files[0]) {
         var pic = new FileReader();
         
         pic.readAsDataURL(this.files[0]);
         pic.addEventListener("load", function(event){
                //debugger;
                 dynamicImageSrc = event.target.result;
                 picForReview.setAttribute("src", event.target.result);
                 //console.log(this.src);
                 picForReview.style.display="block";
             });
         
     }    
 });


 document.getElementById("postButton").addEventListener("click", function(){
    
    if (document.getElementById("inputFile").files[0]||document.getElementById("writeSpace").value!="") {
        
        // Outer container
        const divContainer = document.createElement("div");
        divContainer.className = "p1";
        divContainer.id = "p1";

        // Inner profile pic container
        const profilePicContainer = document.createElement("div");
        profilePicContainer.className = "profilePicBox";
        profilePicContainer.id = "profilePicBox";

        // Profile image
        const profileImageElement = document.createElement("img");
        profileImageElement.className = "profilePic";
        profileImageElement.id = "profilePic";
        profileImageElement.src = "Default_pfp.svg.png";

        // Text area
        const editArea = document.createElement("div");
        editArea.className = "editArea";
        editArea.id = "editArea";
        const divInEditArea = document.createElement("div");
        const text = document.createElement("p");
        const picContainer = document.createElement("div");
        const imageElement = document.createElement("img");
        imageElement.className ="picForReview";
        imageElement.src = dynamicImageSrc;
        text.innerHTML = document.getElementById("writeSpace").value;

        // Line
        const lineDiv = document.createElement("div");
        lineDiv.className = "line3";
        lineDiv.id = "line3";


        
        document.getElementById("pBox").append(divContainer);
        divContainer.append(profilePicContainer);
        profilePicContainer.append(profileImageElement);
        divContainer.append(editArea);
        editArea.append(divInEditArea);
        divInEditArea.append(text);
        divInEditArea.append(picContainer);
        picContainer.append(imageElement);
        imageElement.style.display = "block";
        document.getElementById("pBox").append(lineDiv);

        if (dynamicImageSrc == null) {
            picContainer.style.display = "none";
        }

        if (document.getElementById("writeSpace").value=="") {
            text.style.display = "none";
        }
  
    }
    
    else {

    }
 })