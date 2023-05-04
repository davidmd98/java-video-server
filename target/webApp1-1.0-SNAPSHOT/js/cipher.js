/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cipher(){
    var cipherIn = document.querySelector("#cipher");
    var decipherIn = document.querySelector("#decipher");
    var option = document.querySelector("#cipher-option");
    
    cipherIn.classList.add("active");
    decipherIn.classList.remove("active");
    option.setAttribute("value", "cipher");
}

function decipher(){
    var cipherIn = document.querySelector("#cipher");
    var decipherIn = document.querySelector("#decipher");
    var option = document.querySelector("#cipher-option");
    
    cipherIn.classList.remove("active");
    decipherIn.classList.add("active");
    option.setAttribute("value", "decipher");
}
