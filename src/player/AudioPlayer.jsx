import React, { useState, useRef, useEffect } from 'react';
import AudioPlayerComponent from 'react-h5-audio-player';
import 'react-h5-audio-player/lib/styles.css';
import { Repeat, Shuffle } from 'react-feather';

function AudioPlayer({ audios }) {
    const [selectedAudio, setSelectedAudio] = useState(audios[0]);
    const [selectedAudioIndex, setSelectedAudioIndex] = useState(0);
    const playerRef = useRef(null);  
    const [isRandom, setIsRandom] = useState(false); 
    const [isRepeat, setIsRepeat] = useState(false); 

    const handleNext = () => {
        setIsRandom((isRandom) => {
            const nextIndex = isRandom ? Math.floor(Math.random() * audios.length) : (selectedAudioIndex + 1) % audios.length;
            setSelectedAudio(audios[nextIndex]);
            setSelectedAudioIndex(nextIndex);
        });
    };

    const handlePrev = () => {
        setIsRandom((isRandom) => {
            const prevIndex = isRandom ? Math.floor(Math.random() * audios.length) : (selectedAudioIndex - 1 + audios.length) % audios.length;
            setSelectedAudio(audios[prevIndex]);
            setSelectedAudioIndex(prevIndex);
        });
    };

    const handleEnd = () => {
        if (!isRepeat) {
            handleNext();
        }
        setTimeout(() => {
            playerRef.current.audio.current.play();
        }, 100);
    };

    useEffect(() => {
        const player = playerRef.current?.audio?.current;
        if (player) {
            setTimeout(() => {
                player.play();
            }, 100);
        }
    }, [selectedAudio]);

    useEffect(() => {
        const player = playerRef.current?.audio?.current;
        if (player && selectedAudio) {
            player.src = selectedAudio.audio;  
            player.oncanplaythrough = () => {  
                player.play();
            };
            player.load();
        }
    }, [selectedAudio]);

    return (
        <>
            {selectedAudio && (
                <AudioPlayerComponent
                    autoPlay
                    src={selectedAudio.audio}
                    ref={playerRef}  
                    key={selectedAudio}  
                    onClickNext={handleNext} 
                    onClickPrevious={handlePrev} 
                    onEnded={handleEnd}
                    showSkipControls={true}
                    customAdditionalControls={[
                        <Shuffle onClick={() => {
                            setIsRandom((isRandom) => !isRandom);
                            setIsRepeat((isRepeat) => isRandom ? false : isRepeat);
                        }} color={isRandom ? "blue" : "black"} />,
                        <Repeat onClick={() => {
                            setIsRepeat((isRepeat) => !isRepeat);
                            setIsRandom((isRandom) => isRepeat ? false : isRandom);
                        }} color={isRepeat ? "blue" : "black"} />
                    ]}
                />
            )}
        </>
    );
}
export default AudioPlayer;