package Resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Diller 
{
	public String textfield_birinci_sayi;
	public String textfield_ikinci_sayi;
	public String textfield_sonuc;
	
	public String button_topla;
	public String button_cikar;
	public String button_carp;
	public String button_bol;
	public String button_temizle;
	public String sifira_bolunemez;
	public String yuz;
	public String bin;
	public String milyon;
	public String milyar;
	public String eksi;
	public String eksi_kucuk;
	public String sifir;
	public String birmilyon;
	
	
	private String dil;

	public void setLocale(String dil)
	{
		this.dil = dil;
		if(dil.equals("tr"))
		{
			textfield_birinci_sayi = "Birinci Sayý";
			textfield_ikinci_sayi = "Ýkinci Sayý";
			textfield_sonuc = "Sonuç";
			
			button_topla = "Topla";
			button_cikar = "Çýkar";
			button_carp = "Çarp";
			button_bol = "Böl";
			button_temizle = "Temizle";
			
			sifira_bolunemez = "Sayý Sýfýra Bölünemez!";
			
			yuz = "yüz ";
			bin = "bin ";
			milyon = "milyon ";
			milyar = "milyar ";
			
			eksi = "EKSÝ";
			eksi_kucuk = "eksi ";
			
			sifir = "sýfýr";
			
			birmilyon = "bir milyon ";
		}
		else if(dil.equals("en"))
		{
			textfield_birinci_sayi = "First Number";
			textfield_ikinci_sayi = "Second Number";
			textfield_sonuc = "Result";
			
			button_topla = "Add";
			button_cikar = "Subtract";
			button_carp = "Multiply";
			button_bol = "Divide";
			button_temizle = "Clear";
			
			sifira_bolunemez = "Cannot Divide a Number by Zero";
			
			yuz = "hundred ";
			bin = "thousand ";
			milyon = "million ";
			milyar = "billion ";
			
			eksi = "MINUS";
			eksi_kucuk = "minus ";
			
			sifir = "zero";
			
			birmilyon = "one million ";
		}
	}
	
	public String [] sayilar()
	{
		ArrayList<String> sayilar = new ArrayList<String>();
		if(dil.equals("tr"))
		{
			
			String[] sayilar_tr={"", "BÝR", "ÝKÝ", "ÜÇ", "DÖRT", "BEÞ", "ALTI", "YEDÝ", "SEKÝZ", "DOKUZ", "ON", "YÝRMÝ", "OTUZ", "KIRK", "ELLÝ", "ALTMIÞ", "YETMÝÞ", "SEKSEN", "DOKSAN", "YÜZ", "BÝN", "MÝLYON", "MÝLYAR"};
			sayilar.addAll(Arrays.asList(sayilar_tr));
		}
		else if(dil.equals("en"))
		{
			String[] sayilar_en={"", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY", "HUNDRED", "THOUSAND", "MILLION", "BILLION"};
			sayilar.addAll(Arrays.asList(sayilar_en));
		}
		return sayilar.toArray(new String[0]);
	}
	
	public int [] karsiliklari()
	{
		int dizi_boyut = 0;
		if(dil.equals("tr"))
		{
			dizi_boyut = 23;
		}
		else if(dil.equals("en"))
		{
			dizi_boyut = 32;
		}
		int [] karsiliklari = new int[dizi_boyut];
		if(dil.equals("tr"))
		{
			karsiliklari = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000, 1000000, 1000000000};
		}
		else if(dil.equals("en"))
		{
			karsiliklari = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000, 1000000, 1000000000};
		}
		return karsiliklari;
	}
	
	public int dizi_uzunluk()
	{
		int dizi_boyut = 0;
		if(dil.equals("tr"))
		{
			dizi_boyut = 22;
		}
		else if(dil.equals("en"))
		{
			dizi_boyut = 31;
		}
		return dizi_boyut;
	}
	
	public String [] toUpper(String [] sayilar)
	{
		String [] upper_sayilar = new String[2];
		if(dil.equals("tr"))
		{
			upper_sayilar[0] = sayilar[0].toUpperCase(new java.util.Locale("tr", "TR"));
			upper_sayilar[1] = sayilar[1].toUpperCase(new java.util.Locale("tr", "TR"));
		}
		else if(dil.equals("en"))
		{
			upper_sayilar[0] = sayilar[0].toUpperCase(Locale.ENGLISH);
			upper_sayilar[1] = sayilar[1].toUpperCase(Locale.ENGLISH);
		}
		return upper_sayilar;
	}
	
	public String [] birler()
	{
		String [] birler = new String [10];
		if(dil.equals("tr"))
		{
			birler = new String [] {"","bir ","iki ","üç ","dört ","beþ ","altý ","yedi ","sekiz ","dokuz "};
		}
		else if(dil.equals("en"))
		{
			birler = new String [] {"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
		}
       return birler;
	}
	public String [] birlerx()
	{
		String [] birlerx = new String [10];
		if(dil.equals("tr"))
		{
			birlerx = new String [] {"","","iki ","üç ","dört ","beþ ","altý ","yedi ","sekiz ","dokuz "};
		}
		else if(dil.equals("en"))
		{
			birlerx = new String [] {"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
		}
		return birlerx;
	}
	public String [] onlar()
	{
		String [] onlar = new String [10];
		if(dil.equals("tr"))
		{
			onlar = new String [] {"","on ","yirmi ","otuz ","kýrk ","elli ","altmýþ ","yetmiþ ","seksen ","doksan "};
		}
		else if(dil.equals("en"))
		{
			onlar = new String [] {"","ten ","twenty ","thirty ","forty ","fifty ","sixty ","seventy ","eighty ","ninety "};
		}
		return onlar;
	}
	
	
	
}
