//Upload photo button triggers function
   
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

    document.getElementById("X_button").addEventListener("click", function(){
        console.log("test");
        modalInDisplay.style.display = "none";
        modalBackground.style.display = "none";
        X_button.style.display = "none";
    });



    

//---------------------


    // Get the profile edit modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var editButton = document.getElementById("editButton");

    //Get the save button
    var save = document.getElementById("save");
   

    // When the user clicks on the button, open the modal
    editButton.onclick = function() {
        modal.style.display = "block";
        modalBackground.style.display = "block";
    }
    //When user clicks on the save button, do something
    var originalUsername = document.getElementById("username").innerHTML;
    var orginalBio = document.getElementById("oldBio").innerHTML;
    save.onclick = function() {
        if (document.getElementById("name").value!=""){
                document.getElementById("username").innerHTML = document.getElementById("name").value;
            }
        else
            {
                document.getElementById("username").innerHTML = originalUsername;
            }
        if (document.getElementById("bio").value!=""){
                document.getElementById("oldBio").innerHTML = document.getElementById("bio").value;
            }
        else
            {
                document.getElementById("oldBio").innerHTML = orginalBio;
            }

        modalBackground.style.display = "none";
        modal.style.display = "none";
    }
    //cancel button
    document.getElementById("cancel2").addEventListener("click", function(){
        modalBackground.style.display = "none";
        modal.style.display = "none";
    })


//---------------------


    //Get the photoModal
    var photoModal = document.getElementById("photoModal");
    var confirmationModal = document.getElementById("photoConfirmationModal")

    //Obtain profile image source
    var imgElement = document.getElementById("originalPic");
    var originalURL = imgElement.getAttribute('src');

    //when clicking on the profile photo, modal opens
    document.getElementById("originalPic").addEventListener("click", function(){
        //Obtain profile image source
        //var imgElement = document.getElementById("originalPic");
        var imgURL = imgElement.getAttribute('src');
        document.getElementById("picInModal").setAttribute("src", imgURL);
        photoModal.style.display = "block";
        modalBackground.style.display = "block";
    })

    //update button trigger something
    //Get file
    
    document.getElementById("changePhoto").addEventListener("change", function(){
        var file = document.getElementById("changePhoto");
        var newPic = new FileReader();
        if (file.files[0]){
            newPic.readAsDataURL(file.files[0]);
            /*console.log(newPic);
            console.log(newPic.result);*/
            newPic.addEventListener("load", function(event){
                document.getElementById("picConfirmation").setAttribute("src", event.target.result);
                photoModal.style.display = "none"
                confirmationModal.style.display = "block"
            });
            }
        file.value = "";      
    })

    //picModal delete button
    document.getElementById("delete").addEventListener("click", function(){
        var imgURL = imgElement.getAttribute('src');
        document.getElementById("picDelete").setAttribute("src", imgURL);
        photoModal.style.display = "none"
        photoDeleteModal.style.display = "block"
    })

    //picModal cancel button
    document.getElementById("cancel").addEventListener("click", function(){
        modalBackground.style.display = "none";
        photoModal.style.display = "none"

    })

    //Confirmation yes

    var picConfirmation = document.getElementById("picConfirmation");
    document.getElementById("yesConfirmation").addEventListener("click", function(){
        var picConfirmationURL = picConfirmation.getAttribute('src');
        document.getElementById("originalPic").setAttribute("src", picConfirmationURL);
        modalBackground.style.display = "none";
        photoConfirmationModal.style.display = "none"
    })

    //Confirmation no
    document.getElementById("noConfirmation").addEventListener("click", function(){
        modalBackground.style.display = "none";
        photoConfirmationModal.style.display = "none"
    })

    //Delete yes
    document.getElementById("yesDelete").addEventListener("click", function(){
        document.getElementById("originalPic").setAttribute("src", originalURL);
        modalBackground.style.display = "none";
        photoDeleteModal.style.display = "none"
    })
    

    //Delete no
    document.getElementById("noDelete").addEventListener("click", function(){
        modalBackground.style.display = "none";
        photoDeleteModal.style.display = "none"

    })