let main = {
   init : function (e) {
       $(".btn-outline-secondary").on("click", (e)=> {
           this.delete(e);
       });
   },
  
   delete : function (e) {
	   console.log(e.target.id);
	   let checkId = e.target.id.replace("delete_", "");
	   console.log(checkId);

       let data = {
    		   id : $("#id_" + checkId).val()
       };

       $.ajax({
           type : "DELETE",
           url : "/team/del/"+ data.id,
           dataType : "json",
           contentType : "application/json; charset=utf-8"
       }).done(function () {
           alert("삭제되었습니다.");
           location.href = "/team/list";
       }).fail(function (error) {
           alert("삭제 실패")
           console.log(error);
       })
   }
};

main.init();