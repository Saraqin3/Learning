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
    
    if (document.getElementById("inputFile").files[0]||document.getElementById("writeSpace").value!="") {
        
        // Outer container
        const divContainer = document.createElement("div");
        divContainer.class="p1";
        divContainer.id="element0";

        // Inner profile pic container
        const profilePicContainer = document.createElement("div");
        profilePicContainer.class="profilePicBox";
        profilePicContainer.id="profilePicBox";

        // Profile image
        const imageElement = document.createElement("img");
        imageElement.src = "Default_pfp.svg.png";

        document.getElementById("p2").prepend(divContainer);
        divContainer.prepend(profilePicContainer);
        profilePicContainer.prepend(imageElement);




        document.getElementById("p2").innerHTML = 
            <div class="p1" id="element0">

                        
                <div class="profilePicBox" id="profilePicBox">
                    <img class="profilePic" id="profilePic" src="Default_pfp.svg.png" alt="Profile Image">
                </div>

                <div class="editArea" id="editArea">
                    <div>
                        <input type="text" class="writeSpace" id="writeSpace" placeholder="What's new?" maxlength="50">
                        <div>
                            <img class="picForReview" id="picForReview" src="" alt="Pic For Review">
                        </div>
                    </div>
                    

                </div>

            </div> 

            <div class="line2" id="line2"></div>

       

        + document.getElementById("p2").innerHTML;
    }
    else {

    }
 })