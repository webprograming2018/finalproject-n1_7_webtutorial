/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Subject;

/**
 *
 * @author Admin
 */
public interface SubjectDAO {
    public Subject getSubjectBySubjectID(int subId);
}
