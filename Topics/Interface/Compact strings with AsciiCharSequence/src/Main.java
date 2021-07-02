import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence {
    private byte[] chars;
    public AsciiCharSequence(byte[] chars) {
        this.chars = chars;
    }

    @Override
    public int length() {
        return this.chars.length;
    }

    @Override
    public char charAt(int index) {
        return (char) chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subChars = new byte[end - start];
        for (int i = start, j = 0; i < end; i++, j++) {
            subChars[j] = this.chars[i];
        }
        return new AsciiCharSequence(subChars);
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.chars.length; i++) {
            str += (char) this.chars[i];
        }
        return str;
    }
}