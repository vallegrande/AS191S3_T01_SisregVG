/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import lombok.Data;

@Data
public class Usuario {
  private  int IDUSU;
  private  String USUUSU;
  private  String PWDUSU;
  private  int LEVUSU;
  private  String ESTUSU;
   
 public Usuario(){
 }

    public Usuario(int IDUSU, String USUUSU, String PWDUSU, int LEVUSU, String ESTUSU) {
        this.IDUSU = IDUSU;
        this.USUUSU = USUUSU;
        this.PWDUSU = PWDUSU;
        this.LEVUSU = LEVUSU;
        this.ESTUSU = ESTUSU;
    }

  
 
 
}