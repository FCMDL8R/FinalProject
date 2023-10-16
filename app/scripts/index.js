const newsletterBtn = document.querySelector('.news-input button')

const isValidEmail = (email) => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
};

newsletterBtn.addEventListener("click", () => {
    submitEmail();
})

function submitEmail(btn) {
    if(validateEmailField() == true){
        document.querySelector('.news-input input').value = '';
        alert('Email saved - you will now receive our monthly newsletter. Thank you!')
    }
}

function validateEmailField(){
    let isValid = true
    const userInput = document.querySelector('.news-input input')
    
    if(userInput.value == '') {
        userInput.classList.add("error");
        isValid = false;
    } else if (!isValidEmail(userInput.value)) {
        userInput.classList.add("error");
        isValid = false;
    } else {
        console.log("valid")
    }
    return isValid
}