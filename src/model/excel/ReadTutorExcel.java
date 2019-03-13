package model.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import model.daoFactory.TutorsDAOFactory;
import model.vo.Tutors;

public class ReadTutorExcel 
{
	public static List<Tutors> getAllByDb()
	{
        List<Tutors> list=new ArrayList<Tutors>();
        try {
			list=TutorsDAOFactory.getInstance().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }
	public static List<Tutors> getAllByExcel(String file){
		List<Tutors> list=new ArrayList<Tutors>();
		Tutors tutors=null;
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String tutorID=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String tutorName=rs.getCell(j++,i).getContents();
                    String tutorPwd=rs.getCell(j++,i).getContents();
                    String facultyID=rs.getCell(j++,i).getContents();
                    String profession=rs.getCell(j++,i).getContents();
                    tutors=new Tutors();
                    tutors.setTutorID(tutorID);
                    tutors.setTutorName(tutorName);
                    tutors.setTutorPwd(tutorPwd);
                    tutors.setFacultyID(facultyID);
                    tutors.setProfession(profession);
                    list.add(tutors);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
	public static boolean isExist(String tutorID){
        try {
            Tutors tutors=null;
            tutors=TutorsDAOFactory.getInstance().findById(tutorID);
            if (tutors!=null) 
            {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
