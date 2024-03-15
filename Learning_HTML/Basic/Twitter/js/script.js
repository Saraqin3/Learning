//1111

var picForReview = document.getElementById("picForReview");
var dynamicImageSrc = null;

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
    
    if (document.getElementById("inputFile").files[0]||document.getElementById("writeSpace").value!="") {
        
        // Outer container
        const divContainer = document.createElement("div");
        divContainer.class="p1";
        divContainer.id="p1";

        // Inner profile pic container
        const profilePicContainer = document.createElement("div");
        profilePicContainer.class="profilePicBox";
        profilePicContainer.id="profilePicBox";

        // Profile image
        const profileImageElement = document.createElement("img");
        profileImageElement.src = "Default_pfp.svg.png";

        // Text area
        const editArea = document.createElement("div");
        const divInEditArea = document.createElement("div");
        const text
        const picContainer = document.createElement("div");
        const imageElement = document.createElement("img");
        imageElement.class="picForReview";
        imageElement.src="";

        // Line
        const lineDiv = document.createElement("div");
        lineDiv.class = "line2";


        document.getElementById("pBox").prepend(lineDiv);
        document.getElementById("pBox").prepend(divContainer);
        divContainer.append(profilePicContainer);
        profilePicContainer.append(profileImageElement);
        divContainer.append(editArea);
        editArea.append(divInEditArea);
        divInEditArea.append(text);
        divInEditArea.append(picContainer);
        picContainer.append(imageElement);

        n = n+1;


        
    }
    else {

    }
 })