import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Resources.Diller;

@SuppressWarnings("serial")
public class AnaEkran extends JFrame 
{
	private JPanel contentPane;
	private JTextField textfield_birinci_sayi;
	private JTextField textfield_ikinci_sayi;
	private JTextField textfield_sonuc;
	private boolean negatif_birinci = false;
	private boolean negatif_ikinci = false;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	Diller res = new Diller();
	
	public AnaEkran() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		res.setLocale("en"); //System.getProperty("user.language")
		
		JLabel label_birinci_sayi = new JLabel(res.textfield_birinci_sayi);
		label_birinci_sayi.setBounds(5, 51, 111, 16);
		contentPane.add(label_birinci_sayi);
		
		textfield_birinci_sayi = new JTextField();
		textfield_birinci_sayi.setBounds(128, 48, 424, 22);
		contentPane.add(textfield_birinci_sayi);
		textfield_birinci_sayi.setColumns(10);
		
		JLabel label_ikinci_sayi = new JLabel(res.textfield_ikinci_sayi);
		label_ikinci_sayi.setBounds(5, 116, 111, 16);
		contentPane.add(label_ikinci_sayi);
		
		textfield_ikinci_sayi = new JTextField();
		textfield_ikinci_sayi.setBounds(128, 113, 424, 22);
		contentPane.add(textfield_ikinci_sayi);
		textfield_ikinci_sayi.setColumns(10);
		
		JLabel label_sonuc = new JLabel(res.textfield_sonuc);
		label_sonuc.setBounds(5, 181, 111, 16);
		contentPane.add(label_sonuc);
		
		textfield_sonuc = new JTextField();
		textfield_sonuc.setBounds(128, 178, 424, 22);
		contentPane.add(textfield_sonuc);
		textfield_sonuc.setColumns(10);
		textfield_sonuc.setEditable(false);
		
		JButton button_topla = new JButton(res.button_topla);
		button_topla.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				hesapla("topla");
			}
		});
		button_topla.setBounds(128, 213, 97, 25);
		contentPane.add(button_topla);
		
		JButton button_cikar = new JButton(res.button_cikar);
		button_cikar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				hesapla("cikar");
			}
		});
		button_cikar.setBounds(237, 213, 97, 25);
		contentPane.add(button_cikar);
		
		JButton button_carp = new JButton(res.button_carp);
		button_carp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				hesapla("carp");
			}
		});
		button_carp.setBounds(346, 213, 97, 25);
		contentPane.add(button_carp);
		
		JButton button_bol = new JButton(res.button_bol);
		button_bol.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				hesapla("bol");
			}
		});
		button_bol.setBounds(455, 213, 97, 25);
		contentPane.add(button_bol);
		
		JButton button_temizle = new JButton(res.button_temizle);
		button_temizle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				textfield_birinci_sayi.setText("");
				textfield_ikinci_sayi.setText("");
				textfield_sonuc.setText("");
			}
		});
		button_temizle.setBounds(15, 213, 97, 25);
		contentPane.add(button_temizle);

	}
	
	private void hesapla(String islem)
	{
		boolean negatif_sonuc = false;
		String [] sayilar = sayilari_al();
		long birinci_sayi = donustur(sayilar[0]);
		if(negatif_birinci)
		{
			birinci_sayi *= -1;
			negatif_birinci = false;
		}
		long ikinci_sayi = donustur(sayilar[1]);
		if(negatif_ikinci)
		{
			ikinci_sayi *= -1;
			negatif_ikinci = false;
		}
		
		long sonuc = 0L;
		switch (islem) 
		{
			case "topla":
			{
				sonuc = birinci_sayi + ikinci_sayi;
				break;
			}
			case "cikar":
			{
				sonuc = birinci_sayi - ikinci_sayi;
				break;
			}
			case "carp":
			{
				sonuc = birinci_sayi * ikinci_sayi;
				break;
			}
			case "bol":
			{
				if(ikinci_sayi==0)
				{
					JOptionPane.showMessageDialog(null, res.sifira_bolunemez);
					return;
				}
				sonuc = birinci_sayi / ikinci_sayi;
				break;
			}
		}
		
		if(sonuc < 0)
		{
			negatif_sonuc = true;
			sonuc *= -1;
		}
		String sonuc_y = yaziya_cevir(sonuc);
		if(negatif_sonuc)
		{
			sonuc_y = res.eksi_kucuk.concat(sonuc_y);
			negatif_sonuc = false;
		}
		textfield_sonuc.setText(sonuc_y);
	}
	
	private String [] sayilari_al()
	{
		String [] sayilar = res.toUpper(new String [] {textfield_birinci_sayi.getText(), textfield_ikinci_sayi.getText()});
		sayilar[0] = eksi_kontrol(sayilar[0], 0);
		sayilar[1] = eksi_kontrol(sayilar[1], 1);
		
		return sayilar;
	}
	
	private String eksi_kontrol(String metin, int index)
	{
		String[] ayrilmis_sayi = metin.split("\\s+");
		if(ayrilmis_sayi[0].equals(res.eksi))
		{
			metin = metin.replaceAll((res.eksi+" "), "");
			if(index == 0)
			{
				negatif_birinci = true;
			}
			else if(index == 1)
			{
				negatif_ikinci = true;
			}
		}
		return metin;
	}
	
	private long donustur(String s_sayi)
	{
		String[] ayrilmis_sayi = s_sayi.split("\\s+");
		
		String [] sayilar = res.sayilar();
		int [] n_sayilar = res.karsiliklari();
		
		int [] index_sayilar = new int[35];//25
		int [] int_sayilar = new int[35];//25
	
		int dizi_uzunluk = res.dizi_uzunluk();
		
		for (int sayac=0; sayac<=(ayrilmis_sayi.length-1); sayac++)
		{
			for (int i = 0 ; i <= dizi_uzunluk ; i++)//22
			{
				if(ayrilmis_sayi[sayac].equals(sayilar[i]))
				{
					index_sayilar[sayac] = i;
				}	
			}
		}
		
		for (int sayac=0; sayac<=(index_sayilar.length-1); sayac++)
		{
			if (index_sayilar[sayac]==0)
			{
				break;
			}

			int_sayilar[sayac] = n_sayilar[index_sayilar[sayac]];	
		}
				
		int kat_oncesi_sayi = 0;
		int cikis_degeri=0;
		
		long [] toplam = new long[4];
		
		for(int i = 0 ; i < int_sayilar.length ; i++)
		{
			if(int_sayilar[i] == 0)
			{
				cikis_degeri=i;
				break;
			}
				
			switch(int_sayilar[i])
			{
				case 100:
				{
					if(kat_oncesi_sayi!=0)
					{
						for(int x = 1 ; x <= kat_oncesi_sayi ; x++)
						{
							toplam[0]+=int_sayilar[i-x];
						}
					
						toplam[0]*=100;
						kat_oncesi_sayi=0;
					}
					else
						toplam[0] = 100;
					
					break;
				}
				case 1000:
				{
					if(kat_oncesi_sayi!=0)
					{
						for(int x = 1 ; x <= kat_oncesi_sayi ; x++)
						{
							toplam[1]+=int_sayilar[i-x];
						}
						
						if(toplam[0]<1000)
						{
							toplam[1]+= toplam[0];
							toplam[0]=0;
						}
						
						toplam[1]*=1000;
						kat_oncesi_sayi=0;
					}
					else
					{
						toplam[1] = 1000;
						
						if(toplam[0]<toplam[1] && toplam[0] != 0)
						{
							toplam[1] *= toplam[0];
							toplam[0] = 0;
						}
											
					}
					break;
				}
				case 1000000:
				{
					if(kat_oncesi_sayi!=0)
					{
						for(int x = 1 ; x <= kat_oncesi_sayi ; x++)
						{
							toplam[2]+=int_sayilar[i-x];
						}
						
						if(toplam[0]<1000)
						{
							toplam[2]+= toplam[0];
							toplam[0]=0;
						}
						
						toplam[2]*=1000000;
						kat_oncesi_sayi=0;
					}
					else
					{
						toplam[2] = 1000000;
						
						if(toplam[0] != 0)
						{
							toplam[2] *= toplam[0];
							toplam[0] = 0;
						}						
					}
				
					break;
				}
				case 1000000000:
				{
					if(kat_oncesi_sayi!=0)
					{
						for(int x = 1 ; x <= kat_oncesi_sayi ; x++)
						{
							toplam[3]+=int_sayilar[i-x];
						}
						
						if(toplam[0]<1000)
						{
							toplam[3]+= toplam[0];
							toplam[0]=0;
						}
						
						toplam[3]*=1000000000;
						kat_oncesi_sayi=0;
					}
					else
					{
						toplam[3] = 1000000000;
						
						if(toplam[0] != 0)
						{
							toplam[3] *= toplam[0];
							toplam[0] = 0;
						}						
					}
					
					break;
				}
				default:
				{
					kat_oncesi_sayi++;
				
					break;
				}
			}
		}
		
		for(int i = (cikis_degeri-kat_oncesi_sayi); i<cikis_degeri; i++)
		{
			
			toplam[0]+=int_sayilar[i];
		}

		return ((toplam[0]+toplam[1]+toplam[2]+toplam[3]));
	}

	String yaziya_cevir(long sayix)
	{	
		if(sayix == 0)
        {
        	return res.sifir;
        }
		
		long sayi = sayix;
        int basamak=1;
      
        while(sayi>9)
        {
            sayi=sayi/10;
            basamak++;
        }
        
        String birler[] = res.birler(); 
        String onlar[] = res.onlar(); 
        String birlerx[] = res.birlerx(); 

        String x = "";
        boolean alti = false;
        boolean bes = false;
        boolean dokuz = false;
        boolean sekiz = false;
        switch(basamak)
        {
            case 12: //yüzler
            {
            	x = x.concat(x = x.concat(birlerx[(int)(sayix/100000000000L)%10].concat(res.yuz)));
            }
            case 11: //onlar
            { 
            	x = x.concat(onlar[(int)(sayix/10000000000L)%10]);
            }
            case 10: // birler milyar
            {
        		x = x.concat(birler[(int)(sayix/1000000000)%10].concat(res.milyar));
            }
            case 9: //yüzler
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-9);
            	int sayixi = Integer.parseInt(sayixs);
            	if(sayixi >= 100000000)
            		dokuz = true;
            	if((sayix/100000000)%10 != 0)
        			x = x.concat(birlerx[(int)(sayix/100000000)%10].concat(res.yuz));
            }
            case 8: //onlar
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-8);
            	int sayixi = Integer.parseInt(sayixs);
            	if(sayixi >= 10000000)
            		sekiz = true;
            	x = x.concat(onlar[(int)(sayix/10000000)%10]);
            }
            case 7: //birler milyon
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-7);
            	int sayixi = Integer.parseInt(sayixs);
            	
            	if(sekiz || dokuz || sayixi > 1000000)
            		x = x.concat(birler[(int)(sayix/1000000)%10].concat(res.milyon));
            	
            	if(sayixi == 1000000)
            		x = x.concat(res.birmilyon);
            }
            case 6: //birler yüz
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-6);
            	int sayixi = Integer.parseInt(sayixs);
            	if(sayixi >= 100000)
            		alti = true;
            	//kontrol
            	if((sayix/100000)%10 != 0)
        			x = x.concat(birlerx[(int)(sayix/100000)%10].concat(res.yuz));
            }
            case 5: //onlar
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-5);
            	int sayixi = Integer.parseInt(sayixs);
            	if(sayixi >= 10000)
            		bes = true;
            	x = x.concat(onlar[(int)(sayix/10000)%10]);
            }
            case 4: // birler bin
            {
            	if(bes || alti)
            	{
            		if(sayix < 2000)
            			x = x.concat(birlerx[(int)(sayix/1000)%10].concat(res.bin));
            		else
            			x = x.concat(birler[(int)(sayix/1000)%10].concat(res.bin));	
            	}
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-4);
            	int sayixi = Integer.parseInt(sayixs);
            	if(sayixi >= 1000 && sayixi < 2000)
            		x = x.concat("bin ");
        			
            }
            case 3: //birler yüz
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-3);
            	int sayixi = Integer.parseInt(sayixs);
            	if(sayixi >= 100)
            	{
            		if(sayixi < 200)
            			x = x.concat(birlerx[(sayixi/100)%10].concat(res.yuz));
            		else
            			x = x.concat(birler[(sayixi/100)%10].concat(res.yuz));
            	}
            }
            case 2: //onlar
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-2);
            	int sayixi = Integer.parseInt(sayixs);
            	x = x.concat(onlar[(int)(sayixi/10)%10]);
            }
            case 1: //birler
            {
            	String sayixs = "" + sayix;
            	sayixs = sayixs.substring(sayixs.length()-1);
            	int sayixi = Integer.parseInt(sayixs);
            	x = x.concat(birler[(int)sayixi%10]);
            }
            	
        }
        
        x = x.replaceAll("ten one", "eleven");
        x = x.replaceAll("ten two", "twelve");
        x = x.replaceAll("ten three", "thirteen");
        x = x.replaceAll("ten four", "fourteen");
        x = x.replaceAll("ten five", "fifteen");
        x = x.replaceAll("ten six", "sixteen");
        x = x.replaceAll("ten seven", "seventeen");
        x = x.replaceAll("ten eight", "eighteen");
        x = x.replaceAll("ten nine", "nineteen");
        
        return x;
	}
}
