const steps = Array.from(document.querySelectorAll("form .step"));
const nextBtn = document.querySelectorAll("form .next-btn");
const prevBtn = document.querySelectorAll("form .previous-btn");

nextBtn.forEach((button) => {
    button.addEventListener("click", () => {
        changeStep("next");
    });
});

prevBtn.forEach((button) => {
    button.addEventListener("click", () => {
        changeStep("prev");
    });
});

function changeStep(btn) {
    let index = 0;
    const active = document.querySelector(".active");
    index = steps.indexOf(active)
    steps[index].classList.remove("active");
    if (btn == "next" && validateForm(index) == true) {
        index++;
    } else if (btn == "prev") {
        index--;
    }
    steps[index].classList.add("active");
}

const validateForm = (index) => {
    let inputs = steps[index].querySelectorAll('input')
    let isValid = true;

    for (i = 0; i < inputs.length; i++) {
        if(inputs[i].value == '') {
            inputs[i].nextElementSibling.classList.remove("hidden")
            console.log(inputs[i])
            isValid = false;
        } else {
            inputs[i].nextElementSibling.classList.add("hidden")
        }
    }
    return isValid;
}

