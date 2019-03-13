package model.dao;

import java.util.List;

import model.vo.Sysmanagers;

public interface SysManagersDAO {
	public boolean doCreate(Sysmanagers sysmanager)throws Exception;  
    public List<Sysmanagers> findAll()throws Exception;  
    public Sysmanagers findById(String sysmanagerID)throws Exception;

}
