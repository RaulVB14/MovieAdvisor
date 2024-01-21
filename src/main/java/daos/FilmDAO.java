/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import model.Film;

import java.util.Collection;

/**
 *
 * @author Alex
 */
public interface FilmDAO {
    public Film findById(int id);
    public Collection<Film> findAll();
    public void insert(Film film);
    public void update(Film film);
    public void delete(int id);

}

