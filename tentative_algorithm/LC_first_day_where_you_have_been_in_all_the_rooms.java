class Main {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length; // 방의 개수
        long[] f = new long[n]; // 각 방에 도착하기 위한 일수를 저장할 배열
        final int mod = (int) 1e9 + 7; // 큰 수에 대한 모듈로 연산을 위한 상수

        // 방 1부터 n-1까지의 방문 일수 계산
        for (int i = 1; i < n; ++i) {
            // 방 i에 도착하기 위한 일수 계산
            f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1 + mod) % mod;
        }

        // 마지막 방에 도착하는 데 필요한 일수를 반환
        return (int) f[n - 1];
    }
}
