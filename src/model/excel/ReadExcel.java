package model.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import model.daoFactory.ScoresDAOFactory;
import model.vo.Scores;
import model.vo.Titles;

public class ReadExcel 
{
	public static List<Scores> getAllByDb()
	{
        List<Scores> list=new ArrayList<Scores>();
        try {
			list=ScoresDAOFactory.getInstance().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }
	public static List<Scores> getAllByExcel(String file){
		List<Scores> list=new ArrayList<Scores>();
		Scores score=null;
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//����rwb.getSheet(0)
            int clos=rs.getColumns();//�õ����е���
            int rows=rs.getRows();//�õ����е���
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    String stuID=rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
                    double replyScore=Double.parseDouble(rs.getCell(j++, i).getContents());
                    
                    score=new Scores();
                    score.setStuID(stuID);
                    score.setReplyscore(replyScore);
                    list.add(score);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
	public static boolean isExist(String stuID){
        try {
            Scores score=null;
            score=ScoresDAOFactory.getInstance().findById(stuID);
            if (score!=null) 
            {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	public static List<Titles> getTitlesByExcel(String file){
		List<Titles> list=new ArrayList<Titles>();
		Titles titles=null;
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//����rwb.getSheet(0)
            int clos=rs.getColumns();//�õ����е���
            int rows=rs.getRows();//�õ����е���
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    int titleID=Integer.parseInt(rs.getCell(j++, i).getContents());//Ĭ������߱��Ҳ��һ�� ���������j++
                    String titleName=rs.getCell(j++, i).getContents();
                    String titleAbstract=rs.getCell(j++, i).getContents();
                    
                    titles=new Titles();
                    titles.setTitleID(titleID);
                    titles.setTitleName(titleName);
                    titles.setTitleAbstract(titleAbstract);
                    list.add(titles);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
	
}
