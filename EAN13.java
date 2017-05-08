
public class EAN13 {
	
	public static void main(String[] args) throws Exception{
		
		EAN13 ean = new EAN13();
		System.out.println(ean.calculateEAN13("978382731711"));
		System.out.println(ean.calculateControlCode("978382731711"));
		
	}
	
	/**
	 * @param codeIn code EAN only 12 digits
	 * @return Code control.
	 * @throws Exception codeIn is not 12 digits
	 */
	private int calculateControlCode(String codeIn) throws Exception{
		
		if(codeIn.length() != 12){
			throw new Exception("codeIn length expected 12 obtained " + codeIn.length());
		}
		char[] digit = codeIn.toCharArray();
		int[] xPar = {1,3};
		int sum = 0;
		
		for(int i = 0;i < digit.length;i++){
			sum += Character.getNumericValue(digit[i]) * xPar[i%2];
		}
		int aux = 10 - sum%10;
		return (aux == 10)?0:aux;
		
	}

	/**
	 * @param codeIn
	 * @return
	 * @throws NumberFormatException codeIn invalid number format
	 * @throws Exception codeIn is not 12 digits
	 */
	private Long calculateEAN13(String codeIn) throws NumberFormatException, Exception{
		
		return Long.parseLong(codeIn+calculateControlCode(codeIn));
		
	}

}
