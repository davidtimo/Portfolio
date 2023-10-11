var errorMsg = document.getElementById('error_msg')

let submitBtn = document.getElementById('confirm_btn')
submitBtn.addEventListener('click', (e) => {
    validatePurchase(e)
})

function validatePurchase(e){
    e.preventDefault()

    errorMsg.innerText = 'error'

    let name = document.getElementById('input_name').value
    let product = document.getElementById('input_product').value
    let quan = document.getElementById('input_quantity').value
    let email = document.getElementById('input_email').value
    let phone = document.getElementById('input_number').value
    let receiptYes = document.getElementById("input_yes").checked
    let receiptNo = document.getElementById("input_no").checked
    let address = document.getElementById('input_address').value
    let agree = document.getElementById('input_agree').checked

    if(!validateName(name)){
        return
    } else if(!validateProduct(product)){
        return
    } else if(!validateQuantity(quan)){
        return
    } else if(!email.endsWith('.com')){
        errorMsg.innerHTML = "*Invalid email address"
        return
    } else if(!validatePhone(phone)){
        return
    } else if(!address.endsWith(' Street')){
        errorMsg.innerHTML = "*Address must be ends with Street!"
        return
    } else if(!(receiptYes || receiptNo)){
        errorMsg.innerHTML = "*Please choose whether to receive receipt or not!"
        return
    } else if(!agree){
        errorMsg.innerHTML = "*Please agree to all terms and conditions before confirming your purchase!"
    }
}  

function validateName(name){
    let len = name.length
    let alpha = 0
    if(name.length < 5){
        errorMsg.innerText = "*Name must be at least 5 characters!"
        return false
    }

    for(let i = 0; i < len; i++){
        if((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')){
            alpha++
        }
    }

    if(len != alpha){
        errorMsg.innerText = "*Name must be alphabet!"
        return false
    }

    return true
}

function validateProduct(product){
    if(product == ""){
        errorMsg.innerText = "*Please select a product!"
        return false
    }

    errorMsg.innerText = ""
    return true
}

function validateQuantity(quan){
    let len = quan.length
    if(isNaN(quan)){
        errorMsg.innerText = '*Please enter a number!'
        return false
    }

    if(quan.length < 1){
        errorMsg.innerText = '*Please enter a number!'
        return false
    }

    return true
}

function validatePhone(phone){
    let len = phone.length
    if(isNaN(phone)){
        errorMsg.innerText = '*Please enter a phone number!'
        return false
    }

    if(phone.length < 10 || phone.length > 12){
        errorMsg.innerText = '*Invalid phone number!'
        return false
    }

    return true
}



