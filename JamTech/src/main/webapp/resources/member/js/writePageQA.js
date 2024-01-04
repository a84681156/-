//QA 진행 상황 한개만 선택
function checkOnlyOne(progress) {

  const checkboxes 
    = document.getElementsByName("QA_progress");

  checkboxes.forEach((cb) => {
    cb.checked = false;
  })

  progress.checked = true;
}