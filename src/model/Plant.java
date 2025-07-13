package model;

public class Plant {
        private final String icon = "\uD83C\uDF3F"; // 🌿

        public double getWeight() {
            return 1.0;
        }

        public String getIcon() {
            return icon;
        }

        @Override
        public String toString() {
            return icon;
        }
    }

