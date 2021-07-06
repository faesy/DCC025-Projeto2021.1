/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Exercicio1;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class Exercicio01 {
    public static void main(String[] args){
    float lado1,lado2;
    System.out.println("Digite os lados do Retangulo em Centimetros");
    System.out.println("Lado 1: ");
    Scanner teclado = new Scanner(System.in);
    lado1=teclado.nextFloat();
    System.out.println("Lado 2: ");
    lado2=teclado.nextFloat();
    
    float perimetro_metros= (2*lado1 + 2*lado2) /100;
    System.out.println("O perimetro do Retangulo é de "+perimetro_metros+" Metros");
    }
}
