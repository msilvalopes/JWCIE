/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function logarSe(){
    form = document.getElementById('login2');
    link = document.getElementById('login');
    if(link.style.display == "none"){
        link.style.display = "block";
        form.style.display = "none";
    }else{
        link.style.display = "none";
        form.style.display = "block";
    }
    
}

function startupNow(){
    window.location = "/cadastro";
}

