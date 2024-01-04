//구인구직 하나만 선택가능
function checkOnlyOne1(employment) {

    const checkboxes 
        = document.getElementsByName("employment");

    checkboxes.forEach((cb) => {
        cb.checked = false;
    })

    employment.checked = true;
}

//근무형태 하나만 선택가능
function checkOnlyOne2(workType) {

    const checkboxes 
        = document.getElementsByName("workType");

    checkboxes.forEach((cb) => {
        cb.checked = false;
    })

    workType.checked = true;
}

//근무파트 하나만 선택가능
function checkOnlyOne3(workPart) {

    const checkboxes 
        = document.getElementsByName("workPart");

    checkboxes.forEach((cb) => {
        cb.checked = false;
    })

    workPart.checked = true;
}

//경력유무 하나만 선택가능
function checkOnlyOne4(career) {

    const checkboxes 
        = document.getElementsByName("career");

    checkboxes.forEach((cb) => {
        cb.checked = false;
    })

    career.checked = true;
}

//진행상황 하나만 선택가능
function checkOnlyOne5(progress) {

    const checkboxes 
        = document.getElementsByName("Jobs_progress");

    checkboxes.forEach((cb) => {
        cb.checked = false;
    })

    progress.checked = true;
}