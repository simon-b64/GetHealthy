import type { CalorieEntry } from '$lib/model/CalorieEntry';

export interface DayEntry {
    entries: CalorieEntry[];
    calorieGoal: number;
    carbohydratesGoal: number;
    proteinGoal: number;
    fatGoal: number;
}
