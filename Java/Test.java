class Sample {
    public static void main(String[] args) {
        System.out.print("Start ");
        try {
            String[] texts = new String[5];
            texts[2] = "100";
            texts[3] = null;
            texts[4] = "HelloWorld";

            int num = Integer.parseInt(texts[2]);

            if (num % 2 == 0) {
                System.out.print(texts[3].length());
            } else {
                System.out.print(texts[4].length());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("A");
        } catch (NumberFormatException e) {
            System.out.print("B");
        } catch (Exception e) {
            System.out.print("C");
        } finally {
            System.out.print(" End");
        }
    }
}
