package model.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import model.daoFactory.GraduatesDAOFactory;
import model.vo.Graduates;

public class Addstuexcel 
{
	public static List<Graduates> getAllByDb()
	{
        List<Graduates> list=new ArrayList<Graduates>();
        try {
			list=GraduatesDAOFactory.getInstance().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }
	public static List<Graduates> getAllByExcel(String file){
		List<Graduates> list=new ArrayList<Graduates>();
		Graduates gra=null;
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//鎴栬�卹wb.getSheet(0)
            int clos=rs.getColumns();//寰楀埌鎵�鏈夌殑鍒�
            int rows=rs.getRows();//寰楀埌鎵�鏈夌殑琛�
           
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //绗竴涓槸鍒楁暟锛岀浜屼釜鏄鏁�
                    String stuID=rs.getCell(j++, i).getContents();//榛樿鏈�宸﹁竟缂栧彿涔熺畻涓�鍒� 鎵�浠ヨ繖閲屽緱j++
                    String stuname=rs.getCell(j++, i).getContents();
                    String pw=rs.getCell(j++, i).getContents();
                    String tutorID=rs.getCell(j++, i).getContents();
                    String faID=rs.getCell(j++, i).getContents();
                    String classname=rs.getCell(j++, i).getContents();
                    String year=rs.getCell(j++, i).getContents();
                    
                    gra=new Graduates(); 
                    gra.setStuID(stuID);
                    gra.setStuName(stuname);
                    gra.setStuPwd(pw);
                    gra.setTutorID(tutorID);
                    gra.setFacultyID(faID);
                    gra.setClassname(classname);
                    gra.setYear(year);
                    System.out.println("id:"+gra.getStuID());
                    list.add(gra);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
	
}