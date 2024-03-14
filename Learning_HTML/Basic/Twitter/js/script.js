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
        document.getElementById("p2").innerHTML = '

        <div class="profilePicBox" id="element0">
                    <img class="profilePic" id="profilePic" src="Default_pfp.svg.png" alt="Profile Image">
                </div>
                <div class="editArea" id="editArea">
                    <div>
                        <input type="text" class="writeSpace" id="writeSpace" placeholder="What's new?" maxlength="50">
                        <div>
                            <img class="picForReview" id="picForReview" src="" alt="Pic For Review">
                        </div>
                    </div>
                    <div class="line" id="line"></div>
                    <div class="uploadBar" id="uploadBar">
                        <div class="picForUploadBox" id="picForUploadBox">
                            <input type="file" id="inputFile" style="display: none;">
                            <img class="picForUpload" id="picForUpload" src="images.png" alt="ImagesForUpload" onclick="document.getElementById('inputFile').click();">
                        </div>
                        <div class="middleBlankSpace" id="middleBlankSpace"></div>
                        <div class="postButtonBox" id="postButtonBox">
                            <button class="postButton" id="postButton">Post</button>
                        </div>

                    </div>
                    
                    
                </div>'
        + document.getElementById("p2").innerHTML;
    }
    else {

    }
 })