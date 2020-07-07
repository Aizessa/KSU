function cal2 (){

    var first = document.getElementById("First").value;
        var y = '';
        var e = '';
        var x = '';
        var l = '';
        var t = true;
        if(first.includes('^')&&(first.includes('*')||first.includes('/')||first.includes('+')||first.includes('-'))){
            alert('Wrong inputs try agian')
        }
        else{
    if(first.includes('^')){
    for(let i = 0; i < first.length;i++){
          if(first[i]!='^' && t){
        e += y.concat(first[i])
        }else if(first[i]=='^'){
          t = false;
        }
      else{
        l+=x.concat(first[i])
      }
    }
    document.getElementById("calculater").innerHTML= Math.pow(e,l);

}

    else{
    
document.getElementById("calculater").innerHTML= eval(first);
document.getElementsByClassName("clear")[0].value = ""
if(document.getElementById("calculater").innerHTML % 2 != 0)
document.getElementsByClassName("hide")[0].className = "btn btn-primary butt no";
}}}

function round(){
    document.getElementById("calculater").innerHTML = Math.round(document.getElementById("calculater").innerHTML)
    document.getElementsByClassName("no")[0].className = "btn btn-primary butt no hide";
}
//Factorial loop
function fac_loop(){
    var first = document.getElementById("First").value;
    var loop = document.getElementById("First").value;
    if(first<1 && first > 0){
        alert('The Value Should be 1 or more')
    }
    else if (first == 0){
        loop = 1;
        document.getElementById("calculater").innerHTML = loop ;
    }
    else if (first>0){
    for(let i = first-1 ; i > 0;i--){
        loop *=i; 
    }
    document.getElementById("calculater").innerHTML = loop;
}
else {
    first = first*-1
    for(let i = first-1 ; i > 0;i--){
        loop *=i; 
    }
    document.getElementById("calculater").innerHTML = loop ;
}
}

 //Factorial recursive

function fac_rec(rec = document.getElementById("First").value){

if (rec == 0 ){
    return document.getElementById("calculater").innerHTML = 1;
}
else if(rec > 0  ){

    return document.getElementById("calculater").innerHTML = (rec*fac_rec(rec-1));
}
else if(rec < 0  ){
    rec = rec *-1
    return document.getElementById("calculater").innerHTML = (rec*fac_rec(rec-1)) * -1;
}
else{
    alert('Wrong inputs');
    return document.getElementById("calculater").innerHTML = "";
}

}
function sendEmail() {
Email.send({
    Host : "smtp.elasticemail.com",
    Username : "axalessa@gmail.com",
    Password : "1A589B1D889822095864499C0F17C601344C",
    To : document.getElementById("exampleFormControlInput1").value,
    Cc : document.getElementById("cc").value,
    From : "axalessa@gmail.com",
    Subject : document.getElementById("subject").value,
    Body : document.getElementById("exampleFormControlTextarea1").value
}).then(
  message => alert(message)
);
}

// The email fanction might not work because it is a diffirent computer and maybe the port busy
