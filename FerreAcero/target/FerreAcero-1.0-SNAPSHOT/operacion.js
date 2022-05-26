/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var valorEnvio = "";
function selecOp(valor){
    document.getElementById("valorDeSelect").value = valor//declararle el valor del select al input
  }

function obtenerValor(){
    valor = document.getElementById("valorDeSelect").value//obtener valor del input
    valorEnvio = valor //declarar valor a la variable a usar en el ajax
    console.log(valorEnvio)
    
  
  }



