/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package invproject;

/**
 *
 * @author Celeste Artley
 */
public interface IDatabase<T> {
    void Create(T value);
    String Read();
    void Update(T value);
    void Delete(T value);
}
