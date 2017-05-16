$(document).ready(function () {
    // defaul, hide all .task-group right off the bat
	$(".task-group").hide();
    $(".task-pending").hide();
    
    /* Toggle between personal projects and group projects */
    $("#personal").click(function () {
		$(".task-personal").show();
        $(".task-pending").hide();
		$(".task-group").hide();
		$(this).css("background-color", "#4CAF50");
		$("#group").css("background-color", "#333"); 	
	});
	$("#group").click(function () {
		$(".task-personal").hide();
        $(".task-pending").show();
		$(".task-group").show();
		$(this).css("background-color", "#4CAF50");
		$("#personal").css("background-color", "#333"); 	
	});
    
    /* go to the project clicked on */
    $(document.body).on('click', '.task-personal', function(){
        var index = $(".task-personal").index(this);
		var element =  $(".task-personal").eq(index);
        $("#project").attr("value", element.attr('id'));
        $("#submitForm").submit();        
    });
    /* go to the project clicked on */
    $(document.body).on('click', '.task-group', function(){
        var index = $(".task-group").index(this);
		var element =  $(".task-group").eq(index);
        $("#project").attr("value", element.attr('id'));
        $("#submitForm").submit();
    });
    
    $(".task-pending .accept").click( function() {
        var index = $(".task-pending .accept").index(this);
		var parent =  $(".task-pending").eq(index);
        join("yes", parent.attr("id"));
        parent.remove();
        $(".task-pending-clear").eq(index).remove();
    });
    $(".task-pending .decline").click( function() {
        var index = $(".task-pending .decline").index(this);
		var parent =  $(".task-pending").eq(index); 
        join("no", parent.attr("id"));
        parent.remove();
        $(".task-pending-clear").eq(index).remove();
    });
    
    function join(joinStr, id) {
        $.post('pendingProject', {join:joinStr, proj:id}, function( data ) {
/*            console.log( data.name ); // John
            console.log( data.time ); // 2pm
*/        }, "json");
    }

    
    
});