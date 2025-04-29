package com.puretech.dsa;

class Outer {
     interface Secret {
        void whisper();
    }

     class InnerImpl implements Secret {
        @Override
        public void whisper() {
            System.out.println("Hello from InnerImpl!");
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.new InnerImpl().whisper();

    }
}
