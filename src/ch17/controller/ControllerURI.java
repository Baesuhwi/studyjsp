package ch17.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerURI
 */
@WebServlet(
		urlPatterns = { 
				"/ControllerURI", 
				"*.do"
		}, 
		initParams = { 
				@WebInitParam(name="propertyConfig",value="commandURI.properties")
		})
public class ControllerURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����
	private Map<String, Object> commandMap=new HashMap<String, Object>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ControllerURI() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
    //��ɾ�� ó�� Ŭ������ ���εǾ� �ִ� properties ������ �о
    //HashMap ��ü�� commandMap�� ����
	public void init(ServletConfig config) throws ServletException {
		//initParams���� propertyConfig�� ���� �о��
		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property";	//properties������ ����� ����
		//�� ���ø����̼� ��Ʈ ���
		ServletContext context = config.getServletContext();
		//realFolder�� �� ���ø����̼� �ý��ۻ��� ���� ��η� ����
		String realPath = context.getRealPath(realFolder) + "\\" + props;
		
		//��ɾ�� ó�� Ŭ������ ���� ������ ������ Properties ��ü ����
		Properties pr = new Properties();
		FileInputStream f = null;
		try {
			//command.properties ������ ������ �о��
			f = new FileInputStream(realPath);
			//command.properties�� ������ Properties ��ü pr�� ����
			pr.load(f);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(f != null) try {f.close();} catch(IOException ex) {}
		}
		//Set ��ü�� iterator()�޼ҵ带 ����� Iterator ��ü�� ��
		Iterator<?> keyIter = pr.keySet().iterator();
		//Iterator ��ü�� ����� ��ɾ�� ó�� Ŭ������ commandMap�� ����
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			System.out.println(command);
			try {
				Class<?> commandClass=Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
				System.out.println("commandMap.put" + command);
			}catch (ClassNotFoundException e) {
				throw new ServletException(e);
			}catch (InstantiationException e) {
				throw new ServletException(e);
			}catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)//get ����� ���� �޼ҵ�
			throws ServletException, IOException {
		requestPro(request, response);	//�� ������ ��û ó�� �޼ҵ� ȣ��
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)//post ����� ���� �޼ҵ�
			throws ServletException, IOException {
		requestPro(request, response);	//�� ������ ��û ó�� �޼ҵ� ȣ��
	}

	
	//�� �������� ��û�� �м��ϰ�, �ش� ������ ó���� �� �� ���� ��
	//ó�� ����� �信 ����
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String view = null;
			CommandProcess com=null;
			try {
				String command = request.getRequestURI();
				//������ studyjsp ��θ� �ڸ��� �װ͸� �ϴ� ���ڴ�..
				if(command.indexOf(request.getContextPath()) == 0)//getContextPath�� studyjsp(���)�� ����. indexOf�� ���ڿ����̸� ���Ҷ� ��ġ������
					command=command.substring(request.getContextPath().length());
				com = (CommandProcess)commandMap.get(command);
				System.out.println("requestPro" + command);
				if(com == null) {
					view = "/ch17/process.jsp";
					System.out.println("command == null");
				} else {
					view = com.requestPro(request, response);
					System.out.println(view);
				}
			}catch(Throwable e) {
				throw new ServletException(e);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		
	}
}