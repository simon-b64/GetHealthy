export const TimeUtils = {
    formatTime
};

function formatTime(timestamp: Date | undefined | null): string {
    if (timestamp == null) {
        return '00:00';
    }
    return timestamp.toLocaleTimeString([], {
        hour: '2-digit',
        minute: '2-digit',
        hour12: false
    });
}
