package model;


public class Person {
    private int id;
    private String nombre;
    private int edad;
    private String email;
    private int pais;
    public Person(){}
    public Person (String nombre,int edad, String email,int pais){
        this.nombre=nombre;
        this.edad=edad;
        this.email=email;
        this.pais=pais;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }
}
