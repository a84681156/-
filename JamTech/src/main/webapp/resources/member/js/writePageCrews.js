//구인구직 하나만 선택가능
function checkOnlyOne(progress) {

    const checkboxes 
        = document.getElementsByName("crew_progress");

    checkboxes.forEach((cb) => {
        cb.checked = false;
    })

    progress.checked = true;
}