$(document).ready(function () {
    var jsonID = []; // json objects get loaded into this
	var accepted = []; // hidden inputs are loaded into this array
    
    $(document.body).on("keyup",".name-input", function(e) {
        var index = $(".name-input").index(this);
		var str =  $(".name-input").eq(index).val();
        l(str);
    });
    
    function l(str) {
                var lng = str.length;
        if(lng > 2) {
            $.get("getNames?" + $("#name-form").serialize(), function(data) {
                addName(data);
            });
        }
    }
    
    /* loads all the items from the server into a list and jsonID */
    function addName(userObject) {
        jsonID = [];
        $("#search").empty();
        $.each(userObject, function(index, object) {
            if($.inArray(object.id, accepted) === -1){
                jsonID.push(object.id);
                var item = $("<li>", {"class":"friend-box-item"});
                item.append($("<img>", { "src":object.pic}));
                item.append($("<p>").text(object.name));
                item.append($("<br>"));
                item.append($("<p>").text(object.company));
                $("#search").append(item);
            }
        });
    }

	$(document.body).on('click', '.friend-box-item', function(){
    	// add the person to a input
    	var index = $(".friend-box-item").index(this);
		var element =  $(".friend-box-item").eq(index);
		var id = jsonID[index];
		// create hidden input for including people into the project
		var input = createInput("hidden", "member", id);
		$("#project").append(input);
		// add the person to the selected list
		var list = $("#selected");
		var item = $("<li>", { "class":"selected-box-item"});
		item.append(element.children());
		list.append(item);
		// remove the element from the selected list
		element.remove();
		jsonID.splice(index, 1);
		accepted.push(id);
    });

	$(document.body).on('click', '.selected-box-item', function(){
    	// add the person to a input
    	var index = $(".selected-box-item").index(this);
		var element =  $(".selected-box-item").eq(index);
		var id = accepted[index];
		// find the hidden input and remove it
		$('[name="member"]').each(function () {
			if($(this).val() == id) {
				$(this).remove();
				return false;
			}
		});
		// add the selected item to the search list
		var list = $("#search");
		var item = $("<li>", { "class":"friend-box-item"});
		item.append(element.children());
		list.append(item);
		// remove values from array
		accepted.splice(index, 1);
		jsonID.push(id);
		// add the person to the selected list
		// remove the element from the selected list
		element.remove();
    });



    function createInput(type, name, value='') {
		return $("<input>", {
			"type":type,
			"name":name,
			"value":value
		});
	}
});

