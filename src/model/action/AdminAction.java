package model.action;

import model.daoFactory.FacultyManagersDAOFactory;
import model.daoFactory.GraduatesDAOFactory;
import model.daoFactory.SysManagersDAOFactory;
import model.daoFactory.TutorsDAOFactory;
import model.vo.Facultymanagers;
import model.vo.Graduates;
import model.vo.Sysmanagers;
import model.vo.Tutors;

public class AdminAction {
	public Sysmanagers getSysmanagerInfo(String sysmanagerID)
	{
		Sysmanagers sysmanagers=null;
		try {
			sysmanagers=SysManagersDAOFactory.getInstance().findById(sysmanagerID);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return sysmanagers;
	}
	public boolean submitstu(Graduates gra)
	{
		boolean flag=false;
		  try {
			 flag=GraduatesDAOFactory.getInstance().doCreate(gra);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  return flag;
	}
	
	public boolean submitfa(Facultymanagers fa)
	{
		boolean flag=false;
		  try {
			 flag=FacultyManagersDAOFactory.getInstance().doCreate(fa);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  return flag;
	}
	public boolean submitTutors(Tutors tutor)
	{
		boolean flag=false;
		  try {
			 flag=TutorsDAOFactory.getInstance().doCreate(tutor);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  return flag;
	}
}
