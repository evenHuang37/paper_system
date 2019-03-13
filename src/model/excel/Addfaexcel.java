package model.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import model.daoFactory.FacultyManagersDAOFactory;
import model.vo.Facultymanagers;

public class Addfaexcel 
{
	public static List<Facultymanagers> getAllByDb()
	{
        List<Facultymanagers> list=new ArrayList<Facultymanagers>();
        try {
			list=FacultyManagersDAOFactory.getInstance().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }
	public static List<Facultymanagers> getAllByExcel(String file){
		List<Facultymanagers> list=new ArrayList<Facultymanagers>();
		Facultymanagers fa=null;
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//鎴栬�卹wb.getSheet(0)
            int clos=rs.getColumns();//寰楀埌鎵�鏈夌殑鍒�
            int rows=rs.getRows();//寰楀埌鎵�鏈夌殑琛�
            fa=new Facultymanagers(); 
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //绗竴涓槸鍒楁暟锛岀浜屼釜鏄鏁�
                    String managerID=rs.getCell(j++, i).getContents();//榛樿鏈�宸﹁竟缂栧彿涔熺畻涓�鍒� 鎵�浠ヨ繖閲屽緱j++
                    String managerName=rs.getCell(j++, i).getContents();
                    String managerPwd=rs.getCell(j++, i).getContents();
                    String facultyID=rs.getCell(j++, i).getContents();
                    String telephone=rs.getCell(j++, i).getContents();
                    String email=rs.getCell(j++, i).getContents();
                    
                    fa=new Facultymanagers(); 
                   fa.setManagerName(managerName);
                   fa.setManagerID(managerID);
                   fa.setManagerPwd(managerPwd);
                   fa.setFacultyID(facultyID);
                   fa.setEmail(email);
                   fa.setTelephone(telephone);
                   
                    System.out.println("id:"+fa.getManagerID());
                    list.add(fa);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }

	
}