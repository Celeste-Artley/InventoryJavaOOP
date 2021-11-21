/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package invproject;

/**
 * an interface for a CRUD based database.
 * @author Celeste Artley
 * @param <T>
 * @param <E>
 */
public interface IDatabase<T, E> {
    void Create(E Value);
    E Read(T value);
    void Update(T Sring,E value);
    void Delete(T value);
   
}
