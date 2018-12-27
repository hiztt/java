package mySystem;

import java.io.*;
import java.util.Scanner;


//����ϵͳ
public class ManageSystem extends Borrow{
	protected Member member_list[];
	
	protected int member_amount = 0;
	
	protected int max_capacity = 1000;
		
	protected Book book_list[];
	
	protected DVD DVD_list[];
	
	protected Borrow borrow_list[];
	

	protected int item_amount = 0;
	
	protected int book_number = 0;
	
	protected int DVD_number = 0;
	
	protected int borrow_number = 0;
	
	
	//��ӡ�����鼮
	public void printallbook(){
		for(int j = 0;j<book_number;j++){
			System.out.println("(ͼ��)���:"+book_list[j].item_serial+",����:"+book_list[j].item_name+",����:"+book_list[j].author+",ISBN:"+book_list[j].ISBN+",����:"+book_list[j].item_amount);
		}
	}
	//��ӡ����dvd
	public void printalldvd(){
		for(int j = 0;j<DVD_number;j++){
			System.out.println("(DVD)���:"+DVD_list[j].item_serial+",����:"+DVD_list[j].item_name+",ISRC:"+DVD_list[j].ISRC+",����:"+DVD_list[j].item_amount);
		}
	}
	//����鼮Ԫ��
	public void addnewbook(){
		Scanner input = new Scanner(System.in);
		System.out.print("�������鼮���:");
    	String serial = input.next();
    	System.out.print("�������鼮����:");
    	String name = input.next();
    	System.out.print("����������:");
    	String author = input.next();
    	System.out.print("������ISBN��:(��ʽ 7-15-4456-48):");
    	String ISBN = input.next();
    	System.out.print("�����������Ʒ������:");
    	int num = input.nextInt();
    	book_list[book_number] = new Book();
    	book_list[book_number].item_serial = serial;
    	book_list[book_number].item_name = name;
    	book_list[book_number].item_amount = num;
    	book_list[book_number].author = author;
    	book_list[book_number].ISBN = ISBN;
    	book_number+=1;
    	item_amount+=1;
	}
	//���dvd
	public void addnewdvd(){
		Scanner input = new Scanner(System.in);
		System.out.print("������DVD���:");
    	String serial = input.next();
    	System.out.print("������DVD����:");
    	String name = input.next();
    	System.out.print("������ISRC��:(��ʽ 7-15-4456-48):");
    	String ISRC = input.next();
    	System.out.print("�����������Ʒ������:");
    	int num = input.nextInt();
    	DVD_list[DVD_number] = new DVD();
    	DVD_list[DVD_number].item_serial = serial;
    	DVD_list[DVD_number].item_name = name;
    	DVD_list[DVD_number].ISRC = ISRC;
    	DVD_list[DVD_number].item_amount = num;
    	DVD_number+=1;
    	item_amount+=1;
	}
	
	

	//1.������
	public void menu(){
		System.out.println("-------------------------------------------");
		System.out.println("\t\t1.������Ա");
		System.out.println("\t\t2.������Ʒ");
		System.out.println("\t\t3.�����DVD");
		System.out.println("\t\t4.�����DVD");
		System.out.println("\t\t5.��ʾ���л�Ա��Ϣ ");
		System.out.println("\t\t6.��ʾ������Ʒ��Ϣ ");
		System.out.println("\t\t7.��ʾ���н�����Ϣ");
		System.out.println("\t\t8.�˳�����");
		System.out.println("-------------------------------------------");
		
		Scanner input = new Scanner(System.in);
		int operation = input.nextInt();
		
		
		switch(operation)
		{
		case 1:this.add_member();
		break;
		case 2:this.add_item();
		break;
		case 3:this.borrow_item();
		break;
		case 4:this.return_book();
		break;
		case 5:this.visit_member_list();
		break;
		case 6:this.visit_goods_list();
		break;
		case 7:this.visit_borrow_list();
		break;
		case 8:this.exit();
		break;
		}
	}
	
	//2.������Ա
	public void add_member(){
		Scanner input = new Scanner(System.in);
		System.out.print("��������ӵĻ�Ա���:");
		String serial = input.next();
		System.out.print("��������ӵĻ�Ա����:");
		String name = input.next();
		System.out.print("��������ӵĻ�Ա�ֻ���:");
		String phone_number = input.next();
		
		//----------------------------------------
 	    member_list[member_amount] = new Member();
 	    member_list[member_amount].member_serial_number = serial;
 	    member_list[member_amount].member_name = name;
 	    member_list[member_amount].member_phone_number = phone_number;
 	    member_amount += 1;

	    System.out.println("��Ա��Ϣ��ӳɹ�������");
	    System.out.println("-------------------------------------------");
	    System.out.println("\t\t1.������ӻ�Ա");
	    System.out.println("\t\t2.������һ��");
	    System.out.println("-------------------------------------------");
	    int operation = input.nextInt();
	    if(operation == 1){
	    	//�������
	    	this.add_member();
	    }else{
	    	//������һ��
	    	this.visit_member_list();
	    }

			
     	    
		    

	}
	
	
	//3.������Ʒ
	public void add_item(){

		Scanner input = new Scanner(System.in);
		System.out.print("��������Ҫ��������Ʒ����(----1��ͼ��----2.DVD----):");
	    int operation = input.nextInt();
	    if(operation == 1){
	    	this.addnewbook();
	    }else{
	    	this.addnewdvd();
	    }
 	    
	    System.out.println("��Ʒ��Ϣ��ӳɹ�������");
	    System.out.println("-------------------------------------------");
	    System.out.println("\t\t1.���������Ʒ");
	    System.out.println("\t\t2.�鿴������Ʒ");
	    System.out.println("\t\t3.������ҳ��");
	    System.out.println("-------------------------------------------");
	    int operation1 = input.nextInt();
	    switch(operation1)
	    {
	    case 1:this.add_item();
	    break;
	    case 2:this.visit_goods_list();
	    break;
	    case 3:this.menu();
	    }   

	}

	
	//4.�����DVD
	public void borrow_item(){
		//�Ի�Ա����������֤
		System.out.print("��������Ļ�Ա��:");
		Scanner input = new Scanner(System.in);
		String unchecked_name = input.next();
		for(int j = 0;j<member_amount;j++){
			if(member_list[j].member_name.equals(unchecked_name)){
				System.out.println("��Ա�����֤ͨ��...");
				break;
			}
			if(j==member_amount-1){
				System.out.println("δ�ҵ��û�Ա��Ϣ��������ҳ�档����");
				this.menu();
			}
		}
		System.out.print("������Ҫ���ĵ��鼮����DVD������:");
		String unchecked_item = input.next();
		int j;
		int k;
		for(j = 0;j<book_number && !book_list[j].item_name.equals(unchecked_item);j++){
			if(j==book_number-1){
				for(k = 0;k<DVD_number&& !DVD_list[k].item_name.equals(unchecked_item);k++){
					if(k==DVD_number-1){
						System.out.println("δ�ҵ�ƥ����Ʒ���������˵�");
						this.menu();
					}
				}
				//˵����DVD
				System.out.println("��Ʒƥ��ɹ�����ǰʣ������:"+DVD_list[k].item_amount);
				
				if(DVD_list[k].item_amount>0){
					System.out.print("�����뵱ǰ����(XXXX��XX��XX��):");
					String date = input.next();
					DVD_list[k].item_amount-=1;
					borrow_list[borrow_number] = new Borrow();
					borrow_list[borrow_number].member_name = unchecked_name;
					borrow_list[borrow_number].item_name = unchecked_item;
					borrow_list[borrow_number].time_of_borrowed = date;
					borrow_number++;
					System.out.println("�������㣬���ĳɹ����������˵�������");
					this.menu();
				}else{
					System.out.println("�������㣬�޷����ģ��������˵�������");
					this.menu();
				}
			}
		}
		//˵����book
		System.out.println("��Ʒ���ҵ���ʣ��������:"+book_list[j].item_amount);
		
		if(book_list[j].item_amount>0){
			System.out.print("�����뵱ǰ����(XXXX��XX��XX��):");
			String date = input.next();
			book_list[j].item_amount-=1;
			borrow_list[borrow_number] = new Borrow();
			borrow_list[borrow_number].member_name = unchecked_name;
			borrow_list[borrow_number].item_name = unchecked_item;
			borrow_list[borrow_number].time_of_borrowed = date;
			borrow_number++;
			System.out.println("�������㣬���ĳɹ����������˵�������");
			this.menu();
		}else{
			System.out.println("�������㣬�޷����ģ��������˵�������");
			this.menu();
		}
		
		
		
		
		
		

		
	}
	
	
	//5.�����DVD
	public void return_book(){
		System.out.println("���������������ͽ�����Ʒ���ƣ���@����:");
		Scanner input = new Scanner(System.in);
		String str = input.next();
		if(!str.contains("@")){
			System.out.println("û�м�⵽@���������˵�");
			this.menu();
		}
		
		String[] return_item = str.split("@");
		for(int j = 0;j<borrow_number;j++){
			if(borrow_list[j].member_name.equals(return_item[0])){
				if(borrow_list[j].item_name.equals(return_item[1])){
					
					for(int i = 0;i<book_number;i++){
						if(book_list[i].item_name.equals(return_item[1])){
							book_list[i].item_amount+=1;
						}
						
					}
					for(int i=0;i<DVD_number;i++){
						if(DVD_list[i].item_name.equals(return_item[1])){
							DVD_list[i].item_amount+=1;
						}
					}
					for(int k = j;k<borrow_number;k++){
						borrow_list[k] = borrow_list[k+1];
					}
					borrow_number-=1;
					System.out.println("ƥ��ɹ�����Ʒ�ѹ黹,�������˵�");
					this.menu();

				}
			}
		}
		System.out.println("��Ա��������Ʒ���������󣬷������˵�");
		this.menu();
	}
	
	//6.��ʾ���л�Ա��Ϣ
	public void visit_member_list(){ 
		
		
		for(int j = 0;j<member_amount;j++){
			System.out.println((j+1)+",��Ա���:"+member_list[j].member_serial_number+",��Ա����:"+member_list[j].member_name+",��Ա�绰:"+member_list[j].member_phone_number);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("��Ա��Ϣ��ӡ���!��ǰ����"+(member_amount)+"����Ա");
    	System.out.println("1.�޸Ļ�Ա��Ϣ");
    	System.out.println("2.��ѯ��Ա��Ϣ");
    	System.out.println("3.������Ա��Ϣ");
    	System.out.println("4.ɾ����Ա��Ϣ");
    	System.out.println("5.������ҳ��");
    	int operation = input.nextInt();
	    switch(operation)
	    {
	    case 1:this.modify_memberinfo();
	    
	    case 2:this.search_member();
	    
	    case 3:this.add_member();
	    
	    case 4:this.delete_member();
	    
	    case 5:this.menu();
	    }
		
	}
	
	
	//7.��ʾ������Ʒ��Ϣ
	public void visit_goods_list(){
		this.printallbook();
		this.printalldvd();
		System.out.println("��Ʒ��Ϣ��ӡ���!��ǰ����"+(item_amount)+"����Ʒ");
	    System.out.println("1.������Ʒ��Ϣ");
	    System.out.println("2.�޸���Ʒ��Ϣ");
	    System.out.println("3.������һ��");
	    Scanner input = new Scanner(System.in);
	    int operation = input.nextInt();
	    switch(operation)
	    {
	    case 1:this.add_item();
	    break;
	    case 2:this.modify_item();
	    break;
	    case 3:this.menu();
	    }
		    
		
	}
	
	
	//8.��ʾ���н�����Ϣ
	public void visit_borrow_list(){
		if(borrow_number == 0){
			System.out.println("���޽�����Ϣ��������ҳ��...");
			this.menu();
		}
		for(int j = 0;j<borrow_number;j++){
			System.out.println((j+1)+"."+"���Ļ�Ա����:"+borrow_list[j].member_name+"��������Ʒ����:"+borrow_list[j].item_name+"����������Ϊ:"+borrow_list[j].time_of_borrowed);
			//�������������������get��ǰ���ڣ����
		}
		System.out.println("������Ϣ��ӡ��ϣ�������ҳ��...");
		this.menu();
	}
	
	//9.�޸���Ʒ��Ϣ
	public void modify_item(){
		System.out.println("��������Ҫ���ҵ���Ʒ����(�鼮 �� DVD)����Ʒ���ƣ���'#'����");
		Scanner input = new Scanner(System.in);
		String[] oldStr = input.next().split("#");
		if(oldStr[0].equals("�鼮")){
			for(int j = 0;j < book_number;j++){
				if(book_list[j].item_name.equals(oldStr[1])){
					System.out.println("��Ʒ��ƥ��ɹ����������޸ĺ����Ʒ��Ϣ(�鼮��ţ��鼮���ƣ����ߣ�ISBN�ţ���������@����)");
					String replaceStr = input.next();
					String[] newStr = replaceStr.split("@");
					book_list[j].item_serial = newStr[0];
					book_list[j].item_name = newStr[1];
					book_list[j].author = newStr[2];
					book_list[j].ISBN = newStr[3];
					book_list[j].item_amount = Integer.parseInt(newStr[4]);
					System.out.println("�޸ĳɹ�...");
					System.out.println("---------");
					System.out.println("1.�ٴ��޸�");
					System.out.println("2.������һ��");
					System.out.println("3.������ҳ��");
					int operation = input.nextInt();
				    
				    switch(operation)
				    {
				    	case 1: this.modify_item();
				    	
				    	case 2: this.search_member();
				    	
				    	case 3: this.menu();
				    }   
				}
			}
			System.out.println("δ�ҵ����鼮��������һ��");
			this.visit_goods_list();
		}else if(oldStr[0].equals("DVD")){
			for(int j = 0;j<DVD_number;j++){
				if(DVD_list[j].item_name.equals(oldStr[1])){
					System.out.println("��Ʒ��ƥ��ɹ����������޸ĺ����Ʒ��Ϣ(DVD��ţ�DVD���ƣ�ISRC�ţ���������@����)");
					String replaceStr = input.next();
					String[] newStr = replaceStr.split("@");
					DVD_list[j].item_serial = newStr[0];
					DVD_list[j].item_name = newStr[1];
					DVD_list[j].ISRC = newStr[2];
					DVD_list[j].item_amount = Integer.parseInt(newStr[3]);
					System.out.println("�޸ĳɹ�...");
					System.out.println("---------");
					System.out.println("1.�ٴ��޸�");
					System.out.println("2.������һ��");
					System.out.println("3.������ҳ��");
					int operation = input.nextInt();
				    
				    switch(operation)
				    {
				    	case 1: this.modify_item();
				    	
				    	case 2: this.visit_goods_list();
				    	
				    	case 3: this.menu();
				    }   
				}
			}
			System.out.println("δ�ҵ����鼮��������һ��");
			this.visit_goods_list();
		}else{
			System.out.println("������Ϣ���󣬷�����һ��");
			this.visit_goods_list();
		}
	}
	
	//10.�޸Ļ�Ա��Ϣ
	public void modify_memberinfo(){
		System.out.println("��������Ҫ�޸ĵĻ�Ա��Ϣ(��Ա��ţ��������ֻ�������֮һ����):");
		Scanner input = new Scanner(System.in);
		String oldStr = input.next();
		int j;
		for(j = 0;j<member_amount;j++){
			if(member_list[j].member_serial_number.equals(oldStr)||member_list[j].member_name.equals(oldStr)||member_list[j].member_phone_number.equals(oldStr)){
				System.out.println("��Ҫ�޸ĵĻ�Ա��ϢΪ��"+"��Ա���:"+member_list[j].member_serial_number+"����Ա����:"+member_list[j].member_name+"����Ա�ֻ���Ϊ:"+member_list[j].member_phone_number);
				System.out.println("�������޸ĺ�Ļ�Ա��Ϣ(��Ա��ţ��������ֻ��� ��@����):");
				String replaceStr = input.next();
				//�ж�����Ϸ���
				if(!replaceStr.contains("@")){
					System.out.println("�������������²�ѯ...");
					this.modify_memberinfo();
				}
				String[] newStr = replaceStr.split("@");
				
				//�޸Ľ��ļ�¼�иû�Ա����Ϣ
				for(int i = 0;i<borrow_number;i++){
					if(borrow_list[i].member_name.equals(member_list[j].member_name)){
						borrow_list[i].member_name = newStr[1];
					}
				}
				member_list[j].member_serial_number = newStr[0];
				member_list[j].member_name = newStr[1];
				member_list[j].member_phone_number = newStr[2];
				
				System.out.println("�޸ĳɹ�...");
				System.out.println("---------");
				System.out.println("1.�ٴ��޸�");
				System.out.println("2.��ѯ��Ա��Ϣ");
				System.out.println("3.������ҳ��");
				int operation = input.nextInt();
			    
			    switch(operation)
			    {
			    	case 1: this.modify_memberinfo();
			    	
			    	case 2: this.search_member();
			    	
			    	case 3: this.menu();
			    }   
			}
				
		}
		System.out.println("δ�ҵ�������Ļ�Ա�����Ϣ");
		System.out.println("1.��������");
		System.out.println("2.������ҳ��");
		int operation = input.nextInt();
		switch(operation)
		{
		case 1:this.modify_memberinfo();
		break;
		case 2:this.menu();
		}

	}
	
	
	//11.��ѯ��Ա��Ϣ
	public void search_member(){
		System.out.println("�������Ա��ĳһ����Ϣ(��Ա��ţ��������绰):");
		Scanner input = new Scanner(System.in);
		String keyword = input.next();
		
		int j;
		for(j = 0;j<member_amount;j++){
			if(member_list[j].member_serial_number.contains(keyword)){break;}
			if(member_list[j].member_name.contains(keyword)){break;}
			if(member_list[j].member_phone_number.contains(keyword)){break;}
		}
		System.out.println("��ѯ�����");
		System.out.println("��Ա���:"+member_list[j].member_serial_number+"����Ա����:"+member_list[j].member_name+"����Ա�绰:"+member_list[j].member_phone_number);
		System.out.println("----------------------------------");
		System.out.println("1.�ٴβ�ѯ");
	    System.out.println("2.�޸Ļ�Ա��Ϣ");
	    System.out.println("3.������ҳ��");
	    int operation = input.nextInt();
	    
	    switch(operation)
	    {
	    	case 1: this.search_member();
	    	
	    	case 2: this.modify_memberinfo();
	    	
	    	case 3: this.menu();
	    }    	
		
	}
	
	//12.ɾ����Ա��Ϣ
	public void delete_member(){
		System.out.println("��������Ҫɾ���Ļ�Ա��Ϣ(��Ա��ţ��������ֻ�������֮һ����):");
		Scanner input = new Scanner(System.in);
		String to_delete = input.next();
		System.out.println("��Ҫɾ���Ļ�Ա��Ϣ��:");
		int k;
		for(k = 0;k<member_amount;k++){
			if(member_list[k].member_name.contains(to_delete)){break;}
			if(member_list[k].member_serial_number.contains(to_delete)){break;}
			if(member_list[k].member_phone_number.contains(to_delete)){break;}
		}
		for(int i = 0;i<borrow_number;i++){
			if(borrow_list[i].member_name.equals(member_list[k].member_name)){
				System.out.println("��ǰ��Ա��δ�黹��ͼ���DVD�����ȹ黹��ɾ����Ա��Ϣ��������һ��....");
				this.visit_member_list();
			}
		}

		System.out.println("��Ա���:"+member_list[k].member_serial_number+"����Ա����:"+member_list[k].member_name+"����Ա�绰:"+member_list[k].member_phone_number);
		System.out.println("���ٴ�ȷ���Ƿ�Ҫɾ��:");
		System.out.println("1.�Һ����(�˻ص���ҳ��)");
		System.out.println("2.�ǵģ���ȷ��ɾ��");
		int delete = input.nextInt();
		
		if(delete == 2){
			for(;k<member_amount-1;k++){
				member_list[k]=member_list[k+1];
			}
			member_amount -= 1;
			if(k==member_amount-1){
				member_amount -= 1;
			}
			System.out.println("ɾ���ɹ�������");
			this.menu();
		}else{
			this.menu();
		}
		
		
		
		
	}
	
	
	
	//13.�����ʼ��
	public void init_system(){
		
		
		member_list = new Member[max_capacity];
		book_list = new Book[max_capacity];
		DVD_list = new DVD[max_capacity];
		borrow_list = new Borrow[max_capacity];
		
		
		
		
		//��ʼ����Ա����
		
		
		
		try {
			File file = new File("member.txt");
		        //�ļ�������ʱ�����������ļ���
		    if(!file.exists()){
		        file.createNewFile();
		    }
		    FileReader fileReader = new FileReader("member.txt");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    FileWriter fw = new FileWriter(file,true); //�½���Ա��Ϣ��
		    
		    String str;
		    String[] memberinfo;
		    //��Ա��Ϣ���� �����0��ʼ������λ�ô�һ����Ա��Ϣ
		    int line_number = 1;
		    while((str = bufferedReader.readLine()) != null){
		    	
		    	//��text�е���Ϣ�ָ�
		    	memberinfo = str.split("@");
		    	
		    	//�����ڴ�ռ� 
		    	this.member_amount += 1;
		    	member_list[line_number-1] = new Member();
		    	member_list[line_number-1].member_serial_number = memberinfo[0];
		    	member_list[line_number-1].member_name = memberinfo[1];
		    	member_list[line_number-1].member_phone_number = memberinfo[2];
		    	
		    	line_number++;
		    }
		    
//		    fw.write("����һ��");
		    bufferedReader.close(); 
		    fw.close();
		    

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		//��ʼ����Ʒ����
		
		
		
		
		try {
			File file = new File("product.txt");
		        //�ļ�������ʱ�����������ļ���
		    if(!file.exists()){
		        file.createNewFile();
		    }
		    FileReader fileReader = new FileReader(file);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    FileWriter fw = new FileWriter(file,true); //�½���Ա��Ϣ��
		    
		    String str;
		    String[] iteminfo;
		    //��Ա��Ϣ���� �����0��ʼ������λ�ô�һ����Ա��Ϣ
		    while((str = bufferedReader.readLine()) != null){
		    	
		    	//��text�е���Ϣ�ָ�
		    	iteminfo = str.split("@");
		    	if(iteminfo[0].equals("ͼ��")){
		    	
		    		this.item_amount += 1;
		    		book_list[book_number] = new Book();
		    		book_list[book_number].item_serial = iteminfo[1];
		    		book_list[book_number].item_name = iteminfo[2];
		    		book_list[book_number].author = iteminfo[3];
		    		book_list[book_number].ISBN = iteminfo[4];
		    		book_list[book_number].item_amount = Integer.parseInt(iteminfo[5]);

		    		book_number++;
		    	}else{
		    		
		    		this.item_amount += 1;
		    		DVD_list[DVD_number] = new DVD();
		    		DVD_list[DVD_number].item_serial = iteminfo[1];
		    		DVD_list[DVD_number].item_name = iteminfo[2];
		    		DVD_list[DVD_number].ISRC = iteminfo[3];
		    		DVD_list[DVD_number].item_amount = Integer.parseInt(iteminfo[4]);

		    		DVD_number++;
		    	}
		    }
//		    fw.write("����һ��");
		    fileReader.close();
		    bufferedReader.close(); 
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		//��ʼ����������
		
		
		
		try {
			File file = new File("record.txt");
		        //�ļ�������ʱ�����������ļ���
		    if(!file.exists()){
		        file.createNewFile();
		    }
		    FileReader fileReader = new FileReader("record.txt");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    FileWriter fw = new FileWriter(file,true); //�½���Ա��Ϣ��
		    
		    String str;
		    String[] borrowinfo;
		    //��Ա��Ϣ���� �����0��ʼ������λ�ô�һ����Ա��Ϣ
		    int line_number = 1;
		    while((str = bufferedReader.readLine()) != null){
		    	
		    	//��text�е���Ϣ�ָ�
		    	borrowinfo = str.split("@");
		    	
		    	//�����ڴ�ռ� 
		    	this.borrow_number += 1;
		    	borrow_list[line_number-1] = new Borrow();
		    	borrow_list[line_number-1].member_name = borrowinfo[0];
		    	borrow_list[line_number-1].item_name = borrowinfo[1];
		    	borrow_list[line_number-1].time_of_borrowed = borrowinfo[2];
		    	
		    	line_number++;
		    }
		    
//		    fw.write("����һ��");
		    bufferedReader.close(); 
		    fw.close();
		    

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\t\t����ϵͳ��ʼ���ɹ�...");
	}
	
	
	//14.����ر�ǰ���������
	public void exit(){
		
		//�����Ա��Ϣ�ĸ���
		
		try{ 
			File file = new File("member.txt");  
		    File file2 = new File("member2.txt");  
		    if(!file2.exists()){
		    	file2.createNewFile();
		    }
		     
		    PrintWriter writer = new PrintWriter(file2);   
		    String line;   
		    
		    for(int j = 0;j<member_amount;j++){
		    	writer.println(member_list[j].member_serial_number+"@"+member_list[j].member_name+"@"+member_list[j].member_phone_number);
		    	writer.flush();
		    }
		    writer.close();
		    

		    // ɾ�����ļ�   
		    file.delete();
		    file2.renameTo(file);  
		    
		  
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//������Ʒ��Ϣ�ĸ���
		try{ 
			File file = new File("product.txt");  
		    File file2 = new File("product2.txt");  
		    if(!file2.exists()){
		    	file2.createNewFile();
		    }
		     
		    PrintWriter writer = new PrintWriter(file2);   
		    String line;   
		    
		    for(int j = 0;j<book_number;j++){
		    	writer.println("ͼ��"+"@"+book_list[j].item_serial+"@"+book_list[j].item_name+"@"+book_list[j].author+"@"+book_list[j].ISBN+"@"+book_list[j].item_amount);
		    	writer.flush();
		    }
		    for(int j = 0;j<DVD_number;j++){
		    	writer.println("DVD"+"@"+DVD_list[j].item_serial+"@"+DVD_list[j].item_name+"@"+DVD_list[j].ISRC+"@"+DVD_list[j].item_amount);
		    	writer.flush();
		    }
		   
		    writer.close();

		    // ɾ�����ļ�   
		    file.delete();
		    file2.renameTo(file);  

		}catch(IOException e){
			e.printStackTrace();
		}
		//���������Ϣ
		try{ 
			File file = new File("record.txt");  
		    File file2 = new File("record1.txt");  
		    if(!file2.exists()){
		    	file2.createNewFile();
		    }
		     
		    PrintWriter writer = new PrintWriter(file2);   
		    String line;   
		    
		    
		    for(int j = 0;j<borrow_number;j++){
		    	writer.println(borrow_list[j].member_name+"@"+borrow_list[j].item_name+"@"+borrow_list[j].time_of_borrowed);
		    	writer.flush();
		    }
		   
		    writer.close();

		    // ɾ�����ļ�   
		    file.delete();
		    file2.renameTo(file);  
		    System.out.println("���򼴽�����������");
		    System.exit(0);
		  
		}catch(IOException e){
			e.printStackTrace();
		}
			
	
	}
	

	
}


