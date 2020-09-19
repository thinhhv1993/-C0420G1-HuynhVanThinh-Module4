package furama.model;

import java.util.HashMap;
import java.util.Map;

public class KhachHangSession {
    public Map<KhachHang,Integer> khachHangIntegerMap;

    public KhachHangSession() {
        khachHangIntegerMap = new HashMap<>();
    }

    public Map<KhachHang, Integer> getKhachHangIntegerMap() {
        return khachHangIntegerMap;
    }

    public void setKhachHangIntegerMap(Map<KhachHang, Integer> khachHangIntegerMap) {
        this.khachHangIntegerMap = khachHangIntegerMap;
    }

    public void addKhachHangSession(KhachHang khachHang){
        khachHangIntegerMap.put(khachHang,1);
    }
    public void removeKhachHangSession(KhachHang khachHang){
        khachHangIntegerMap.remove(khachHang,1);
    }
}
