import React from 'react';
import { ScrollView, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { MainContainer } from '../components/Provider/MainContainer';

export const GameScreen = React.memo(() => {
  return (
    <MainContainer paddingHorizontal={0}>
      <ScrollView contentContainerStyle={styles.container}>

        <View style={styles.banner}>
          <Text style={styles.title}>NAVARA</Text>
          <Text style={styles.subtitle}>ROLEPLAY</Text>
          <Text style={styles.status}>● السيرفر متصل</Text>
        </View>

        <View style={styles.info}>
          <Text style={styles.infoTitle}>NAVARA ROLEPLAY</Text>
          <Text style={styles.infoText}>
            مرحباً بك في عالم NAVARA
          </Text>
        </View>

        <TouchableOpacity
  style={styles.playButton}
  onPress={() => {
    // دخول إلى سيرفر NAVARA
  }}
>
  <Text style={styles.playText}>دخول إلى NAVARA</Text>
</TouchableOpacity>
          
        

        <View style={styles.news}>
          <Text style={styles.newsTitle}>📰 آخر الأخبار</Text>
          <Text style={styles.newsText}>
            تابع آخر تحديثات وأخبار السيرفر هنا.
          </Text>
        </View>

      </ScrollView>
    </MainContainer>
  );
});

const styles = StyleSheet.create({
  container: {
    padding: 16,
    paddingBottom: 40,
  },

  banner: {
    height: 220,
    borderRadius: 20,
    backgroundColor: '#151923',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 16,
  },

  title: {
    color: '#ffffff',
    fontSize: 42,
    fontWeight: '900',
    letterSpacing: 5,
  },

  subtitle: {
    color: '#8cff00',
    fontSize: 18,
    fontWeight: '700',
    letterSpacing: 4,
  },

  status: {
    color: '#8cff00',
    marginTop: 18,
    fontSize: 15,
    fontWeight: '700',
  },

  info: {
    backgroundColor: '#202431',
    borderRadius: 16,
    padding: 18,
    marginBottom: 16,
  },

  infoTitle: {
    color: '#ffffff',
    fontSize: 20,
    fontWeight: '800',
    textAlign: 'right',
  },

  infoText: {
    color: '#aeb4c2',
    fontSize: 14,
    marginTop: 8,
    textAlign: 'right',
  },

  playButton: {
    height: 58,
    borderRadius: 16,
    backgroundColor: '#35c759',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 16,
  },

  playText: {
    color: '#ffffff',
    fontSize: 19,
    fontWeight: '900',
  },

  news: {
    backgroundColor: '#202431',
    borderRadius: 16,
    padding: 18,
  },

  newsTitle: {
    color: '#ffffff',
    fontSize: 18,
    fontWeight: '800',
    textAlign: 'right',
  },

  newsText: {
    color: '#aeb4c2',
    marginTop: 8,
    textAlign: 'right',
  },
});
