import React from 'react';
import { Text } from 'react-native';
import { LoaderContainer } from '../components';

export const ModeScreen = React.memo(() => {
  return (
    <LoaderContainer>
      <Text style={{ color: '#ffffff', fontSize: 24 }}>
        NAVARA ROLEPLAY
      </Text>
    </LoaderContainer>
  );
});
