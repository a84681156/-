// 체크박스 전체 선택
$( "#cb3").on("click", function () {
    let $checked = $(this).is(":checked");
  
    if($checked){
        $(this).parents(".agreeForm").find('input[class="chkBox"]').prop("checked", true);
    } else {
        $(this).parents(".agreeForm").find('input[class="chkBox"]').prop("checked", false);
    }
  });

// 체크박스 개별 선택에서 전부다 선택되면 전체선택 자동체크
$("input[class='chkBox']").on("click", function() {
    let $checked1 = $("#cb1").is(":checked");
    let $checked2 = $("#cb2").is(":checked");
  
    if (!($checked1 && $checked2)) {
        $("#cb3").prop("checked", false);
    } else{
        $("#cb3").prop("checked", true);
    }
  });
    
$(".btn").on("click", function(){    
    if($("#cb1").is(":checked") == false){
        alert("모든 약관에 동의 하셔야 회원가입 진행이 가능합니다.");
        return false;
    }else if($("#cb2").is(":checked") == false){
        alert("모든 약관에 동의 하셔야 회원가입 진행이 가능합니다.");
        return false;;
    }else if($("#cb3").is(":checked") == false){
        alert("모든 약관에 동의 하셔야 회원가입 진행이 가능합니다.");
        return false;
    }else{
        return true;
    }
});   


    