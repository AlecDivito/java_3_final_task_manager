$(document).ready(function () {
	var drop_down_img = "images/pictures/ic_arrow_drop_down_black_24dp_1x.png";
	var drop_up_img = "images/pictures/ic_arrow_drop_up_black_24dp_1x.png";
	var option_img = "images/pictures/ic_more_vert_black_24dp_1x.png";

	/********************************************************/
	/* Used for expanding and despanding desc boxes			*/
	/********************************************************/
	// opening the dialog box (if it is closed, open it) 
	$(document.body).on('click', '.closed', function(){
	    var index = $(".desc-box").index(this);
		var element =  $(".desc-box").eq(index);
		element.parent()
			.css({ 
				"white-space" : "normal",
				"overflow" : "visable",
				"color": "black"
			});
		element.attr("src", drop_up_img );
		element.addClass("open");
		element.removeClass("closed");
	}) 	// closing the dialog box (if it is open, close it)
	.on('click', '.open', function(){
		var index = $(".desc-box").index(this);
		var element =  $(".desc-box").eq(index);
		element.parent()
			.css({ 
				"white-space" : "nowrap",
				"overflow" : "hidden",
				"color": "gray"
			});
		element.attr("src", drop_down_img );
		element.addClass("closed");
		element.removeClass("open");
	});
    
	/********************************************************/
	/* listener for clicking on the pictures with the 3 dots*/
	/********************************************************/    
    $(document.body).on('click', '.tag-menu-pic', function() {
//	    var index = $(".tag-menu-pic").index(this);
//		var parent =  $(".tag-menu-pic").eq(index).parent();	
//        parent.append($("<p>").text("Edit"));
//        parent.append($("<p>").text("Delete"));
        alert("This button was supposed to give you a drop down \n\
menu that gave you options to edit or delete the sub task but\n\
because of time constraints was droped saddly :(((");
    });

	/********************************************************/
	/* 1. add a task input to the board						*/
	/********************************************************/
	$(".add-task").click( function() {
	    var index = $(".add-task").index(this);
		var element =  $(".add-task").eq(index);	
		if (!isAddingTask) {
			isAddingTask = true;
			// insert section to the article
			var section = $("<section>", {"draggable":"true"});
			element.before(section);
			// add the tag
			var img = $("<div>")
                    .append($("<img>", {"class":"tag-profile-pic",'src':page.userPic}));
			section.append(img);
            
// type name placeholder id value
			var form = $("<form>");
			form.attr("id", "input-form");
			var tagList = $("<select>", {"class":"input-tag"});
            for(var i = 0; i < object.tags.length; i++) {
                var option = $("<option>", {"value":i, "class":"input-tag-option"});
                option.text(object.tags[i]);
                tagList.append(option);
            }
            form.append(tagList);
			form.append(createInput("text", "title", "Title...", "input-title"));
			form.append($("<textarea>").text("(Input Task Description Here)"));
			form.append(createInput("button", "create", "", "input-create", "Create Task"));
			form.append(createInput("button", "destroy", "", "input-destroy","Destroy Task"));

			section.append(form);			
		} else {
			alert("you can only all one task at a time!");
		}
	});

	/********************************************************/
	/* 2. adding Tags to the task 						*/
	/********************************************************/
	$(document.body).on("click",".input-tag-option", function() {
        var index = $(".input-tag-option").index(this);
		var element =  $(".input-tag-option").eq(index);

		var p = $("<p>", {"class":"p-tags " + object.color[element.val()]}).text($(this).text());
		$(this).parent().parent().prepend(p);
		element.remove();
	});

	/********************************************************/
	/* 3 a). Perpare The Task 								*/
	/********************************************************/
	$(document.body).on("click","#input-create", function() {
		if ( $("#input-title").value === 0 ) {
			alert("The Sub-Task needs a Title");
			return;
		}
		var grandParent = $(this).closest("section");
		var article = $(this).parents("article");
		var title = article.children("h4");
		var tagArray = $('.p-tags').map(function () {
			return $(this).text();
		}).get();
		var colorArray = [];
		for (var i = 0; i < tagArray.length; i++) {
			var index = object.tags.indexOf(tagArray[i]);
			colorArray.push(object.color[index]);
		}

		var data = {
			tag : tagArray ,
			color : colorArray ,
            user  : page.user,
			title : title.text(), 
			subTitle : $("#input-title").val(),
			desc : $("textarea").val(),
            action : "user created a task"
		};
		createSection(grandParent, tagArray, $("#input-title").val(), $("textarea").val());
		var obj = JSON.stringify(data, null, ' ');
        updateServer(obj);
		isAddingTask = false;
	});

	/********************************************************/
	/* 3 b). deleting The pre-made-Task						*/
	/********************************************************/
	$(document.body).on("click","#input-destroy", function() {
		var grandParent = $(this).closest("section");
		removeKids(grandParent);
		grandParent.remove();
		isAddingTask = false;
	});

	/********************************************************/
	/* 4. Create The Sub-Task								*/
	/********************************************************/
	function createSection(section,tagArray,title,text) {
		removeKids(section);
		// add the tag
		var tag = $("<div>", {"class":"tag"});
		var profileImg = $("<img>", {"class":"tag-profile-pic", "src":page.userPic});
		var optionImg = $("<img>", {"class":"tag-menu-pic", "src":option_img});
		tag.append(profileImg);
		for (var i = 0; i < tagArray.length; i++) {
			var index = object.tags.indexOf(tagArray[i]);
			tag.append($("<div>", {"class" : "item-tag " + object.color[index]}));
		}
		tag.append(optionImg);
        section.append(page.username);
		section.append(tag);

		// add title
		section.append($("<p>", {"class":"task-title"}).text(title));

		// add description
		var desc = $("<div>", {"class":"desc"});
		desc.text(text);
		desc.prepend($("<img>", {"class":"desc-box closed", "src":"images/pictures/ic_arrow_drop_down_black_24dp_1x.png"}));
		section.append(desc);
		section.append($("<div>", {"style":"clear:both"}));
	}

	/********************************************************/
	/* 5. Update The server with the new sub-task 			*/
	/********************************************************/
	function updateServer(jsonObj) {
        var data = { data:jsonObj };
		$.post('update', data);
	}
    
    /********************************************************/
	/* Move a subtask to a new task with drag and drop		*/
	/********************************************************/
    var dragged;

    /* events fired on the draggable target */
    $(document.body).on('drag','body',function(e) {});
    document.addEventListener("dragstart", function( event ) {
        // store a ref. on the dragged elem
        dragged = event.target;
        // make it half transparent
        event.target.style.opacity = .5;
    }, false);
    document.addEventListener("dragend", function( event ) {
        // reset the transparency
        event.target.style.opacity = "";
    }, false);
    /* events fired on the drop targets */
    document.addEventListener("dragover", function( event ) {
        // prevent default to allow drop
        event.preventDefault();
    }, false);
    document.addEventListener("dragenter", function( event ) {
        // highlight potential drop target when the draggable element enters it
        if ( event.target.className == "dropzone" ) {
            event.target.style.background = "purple";
        }
    }, false);
    document.addEventListener("dragleave", function( event ) {
        // reset background of potential drop target when the draggable element leaves it
        if ( event.target.className == "dropzone" ) {
            event.target.style.background = "";
        }
    }, false);
    document.addEventListener("drop", function( event ) {
        // prevent default action (open as link for some elements)
        event.preventDefault();
        // move dragged elem to the selected drop target
        if ( event.target.className == "dropzone" ) {
            var parent = event.target;
            parent.style.background = "";
            
            var oldTaskTitle = dragged.parentNode.childNodes[1].innerHTML;
            dragged.parentNode.removeChild( dragged );
            parent.insertBefore(dragged, parent.childNodes[2]);
  
            // update the task id, action desc, and time
            var index = $("section").index(dragged);
            
            var subTaskTitle = $("section").eq(index).find($('.task-title')).text();
            var newTaskTitle = parent.childNodes[1].innerHTML;
            var data = {
                    action : "user moved Subtask " + subTaskTitle +
                            " to " +  newTaskTitle,
                    oldtaskTitle : oldTaskTitle,
                    newtaskTitle : newTaskTitle,
                    subTitle  : subTaskTitle
            };
            if(newTaskTitle !== oldTaskTitle) {
                $.post('updatePosition', {dataObject : JSON.stringify(data)});
            }
        }
    }, false);
    
    /* Send a message to the server that you updated the subtasks poition */

        
   


	$("#cancel").click( function () {
		$("#message").css("display","none");
		$("#overlay").css("display","none");
	});



	/********************************************************/
	/* HELPER FUNCTION 										*/
	/********************************************************/
	function getAllElementsText(selector) {
		return $(selector).map(function() {
			return $(this).text();
		});
	}


	/* remove all children from a parent */
	function removeKids(parent) {
		parent.empty();
	}


	function createInput(type, name, placeholder, id, value="") {
		return $("<input>", {
			"type":type,
			"name":name,
			"placeholder":placeholder,
			"id":id,
			"value":value
		});
	}

	var isAddingTask = false;


});

object = {
	tags :  [   "Important"
				,"Not-Important"
                ,"Warning"
				,"Easy"
                ,"Difficult"
                ,"Hard"
                ,"Complex"
				,"redundant"
                ,"Need-less"
                ,"Back-end"
                ,"Frontend"
			],
	color : [	"col-green"   
                ,"col-yellow"
                ,"col-orange" 
                ,"col-red"    
                ,"col-purple" 
                ,"col-blue"   
                ,"col-lightblue"  
                ,"col-lime"    
                ,"col-pink"   
                ,"col-black"   
                ,"col-aqua" 
			]
};


